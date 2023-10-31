package pagination;


import java.util.concurrent.Callable;

public abstract class PageRequestCallable implements Callable {

    private int pageNumber;
    private PaginationAPIResponse paginationAPIResponse;
    private PageViewInterface mPageViewInterface;

    public PageRequestCallable(PageViewInterface pageViewInterface) {
        this.mPageViewInterface = pageViewInterface;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void updatePageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PaginationAPIResponse getPaginationAPIResponse() {
        return paginationAPIResponse;
    }

    public void setPaginationAPIResponse(PaginationAPIResponse paginationAPIResponse) {
        this.paginationAPIResponse = paginationAPIResponse;
    }

    public PageViewInterface getPageViewInterface() {
        return mPageViewInterface;
    }

    public void setPageViewInterface(PageViewInterface mPageViewInterface) {
        this.mPageViewInterface = mPageViewInterface;
    }

    public interface ResponseListener{
        void sendResponse(PaginationAPIResponse paginationAPIResponse);
    }
}
