package pagination;

public interface PageManagerInterface {
    boolean setLoadingComplete(Object response);
    boolean setLoadingCompleteDueToError(String errorMsz);
    boolean setPaginationStoppedDueToError();
    boolean setLimitReached();
    boolean stopPagination();
}
