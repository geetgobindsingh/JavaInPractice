package pagination;

import Utils.It;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PageManager implements PageManagerInterface {

    //region Private variables
    private static final String TAG = PageManager.class.getSimpleName();

    private static final int PAGE_ZERO = 0;

    private AtomicInteger mCurrentPage = new AtomicInteger(PAGE_ZERO);

    private int mPageSize;

    private AtomicBoolean mLoadingState = new AtomicBoolean(false);

    private AtomicBoolean mLimitReached = new AtomicBoolean(false);

    private Paginator mPaginator;

    private PageManagerViewInterface mPageManagerViewInterface;

    private boolean isInitiated = false;
    //endregion


    //region Constructor
    public PageManager(int pageSize, PageManagerViewInterface pageManagerViewInterface, PageRequestCallable pageRequestCallable) {
        setPageSize(pageSize);
        this.mPageManagerViewInterface = pageManagerViewInterface;
        mPaginator = new Paginator(pageSize, pageRequestCallable, PageManager.this);

    }
    //endregion

    public void startPagination() {

        isInitiated = true;

        mPaginator.startBackgroundThread();

        setCurrentPageNumber(PAGE_ZERO);

        setLoadingStarted();

        resetLimitReachedToStart();

        // Hit api
        mPaginator.requestPage(getCurrentPageNumber(), false);
    }

    public void loadNextPage() {
        if (It.isFalse(mLoadingState.get()) && It.isFalse(mLimitReached.get())) {

            incrementCurrentPageNumber();

            setLoadingStarted();

            // Hit api
            mPaginator.requestPage(getCurrentPageNumber(), true);
        }
    }

    // region setter methods
    public void setPageSize(int pageSize) {
        mPageSize = pageSize;
    }

    public void setCurrentPageNumber(int pageNumber) {
        mCurrentPage.set(pageNumber);
    }

    public void incrementCurrentPageNumber() {
        mCurrentPage.incrementAndGet();
    }

    public boolean setLoadingStarted() {
        mPageManagerViewInterface.showLoading();
        return mLoadingState.compareAndSet(false, true);
    }

    @Override
    public boolean setLoadingComplete(Object response) {
        if (response != null) {
            mPageManagerViewInterface.pageResponseData(response);
        }
        mPageManagerViewInterface.hideLoading();
        return mLoadingState.compareAndSet(true, false);
    }

    @Override
    public boolean setLoadingCompleteDueToError(String errormsz) {
        if (It.isNotEmpty(errormsz)) {
            mPageManagerViewInterface.shoErrorMessage(errormsz);
        }
        mPageManagerViewInterface.hideLoading();
        return mLoadingState.compareAndSet(true, false);
    }

    public boolean resetLimitReachedToStart() {
        return mLoadingState.compareAndSet(true, false);
    }

    @Override
    public boolean setLimitReached() {
        mPageManagerViewInterface.hideLoading();

        setLoadingComplete(null);

        mPaginator.stopBackgroundThread();

        return mLimitReached.compareAndSet(false, true);
    }

    @Override
    public boolean setPaginationStoppedDueToError() {
        return setLimitReached();
    }

    @Override
    public boolean stopPagination() {
        return setLimitReached();
    }
    //endregion

    // region Getter methods
    public int getCurrentPageNumber() {
        return mCurrentPage.get();
    }

    public int getPageSize() {
        return mPageSize;
    }

    public boolean isPageLoading() {
        return mLoadingState.get();
    }

    public boolean isLimitReached() {
        return mLimitReached.get();
    }

    public boolean isInitiated() {
        return isInitiated;
    }
    //endregion

}

