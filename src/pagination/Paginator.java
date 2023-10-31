package pagination;

import Utils.It;

import java.util.concurrent.*;

public class Paginator {

    private static final String TAG = Paginator.class.getSimpleName();
    public static final String PAGE_LIMIT_REACHED = "PAGE_LIMIT_REACHED";
    public static final String CANNOT_RUN_ON_MAIN_THREAD = "CANNOT_RUN_ON_MAIN_THREAD";
    public static final String NO_INTERNET_CONNECTION = "NO_INTERNET_CONNECTION";
    public static final String NO_RESPONSE = "NO_RESPONSE";

    private ExecutorService backgroundThread;
    private int mPageSize;
    private PageRequestCallable mPageRequestCallable;
    private Future mCurrentPageFuture;
    private Object currentPageResponse = null;
    private PageManagerInterface mPageManagerInterface;

    public Paginator(int pageSize, PageRequestCallable pageRequestCallable, PageManagerInterface pageManagerInterface) {
        this.mPageSize = pageSize;
        this.mPageRequestCallable = pageRequestCallable;
        this.mPageManagerInterface = pageManagerInterface;
        this.currentPageResponse = null;
    }

    public void startBackgroundThread() {
        backgroundThread = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public void stopBackgroundThread() {
        if (It.isNotNull(backgroundThread)) {
            backgroundThread.shutdown();
            backgroundThread = null;
        }
    }

    public void requestPage(final int pageNumber, final boolean nextPageRequest) {
        if (It.isNotNull(backgroundThread)) {

            backgroundThread.execute(new Runnable() {
                @Override
                public void run() {
                    try {

                        if (nextPageRequest) {
                            mPageRequestCallable.updatePageNumber(pageNumber);
                        }

                        mCurrentPageFuture = backgroundThread.submit(mPageRequestCallable);

                        PaginationAPIResponse paginationAPIResponse = null;

                        paginationAPIResponse = (PaginationAPIResponse) mCurrentPageFuture.get();

                        if (It.isNotNull(paginationAPIResponse) && It.isNotNull(paginationAPIResponse.getResponse())) {

                            setCurrentPageResponse(paginationAPIResponse.getResponse());

                            if (paginationAPIResponse.getResponseType() == PaginationAPIResponse.SUCCESS) {
                                mPageManagerInterface.setLoadingComplete(getCurrentPageResponse());
                            } else if (paginationAPIResponse.getResponseType() == PaginationAPIResponse.ERROR) {
                                if (paginationAPIResponse.getResponse().equals(PAGE_LIMIT_REACHED)) {
                                    mPageManagerInterface.setLimitReached();
                                } else {
                                    mPageManagerInterface.setLoadingCompleteDueToError((paginationAPIResponse.getResponse() instanceof String) ? (String) paginationAPIResponse.getResponse() : "");
                                }
                            }
                        } else {
                            mPageManagerInterface.setLoadingCompleteDueToError("NO_RESPONSE");
                        }
                    } catch (InterruptedException e) {
                        mPageManagerInterface.setLoadingCompleteDueToError((It.isNotEmpty(e.getMessage()) ? e.getMessage() : ""));
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        mPageManagerInterface.setLoadingCompleteDueToError((It.isNotEmpty(e.getMessage()) ? e.getMessage() : ""));
                        e.printStackTrace();
                    } catch (ClassCastException e) {
                        mPageManagerInterface.setLoadingCompleteDueToError((It.isNotEmpty(e.getMessage()) ? e.getMessage() : ""));
                        e.printStackTrace();
                    } catch (Exception e) {
                        if (e instanceof CannotRunOnMainThreadException) {
                            mPageManagerInterface.setLoadingCompleteDueToError(CANNOT_RUN_ON_MAIN_THREAD);
                            e.printStackTrace();
                        } else if (e instanceof NoInternetException) {
                            mPageManagerInterface.setLoadingCompleteDueToError(NO_INTERNET_CONNECTION);
                            e.printStackTrace();
                        } else {
                            mPageManagerInterface.setLoadingCompleteDueToError((It.isNotEmpty(e.getMessage()) ? e.getMessage() : ""));
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }


    public void setCurrentPageResponse(Object response) {
        this.currentPageResponse = response;
    }

    public Object getCurrentPageResponse() {
        return currentPageResponse;
    }

    public class CannotRunOnMainThreadException extends Exception {
    }

    public class NoInternetException extends Exception {
    }

}


