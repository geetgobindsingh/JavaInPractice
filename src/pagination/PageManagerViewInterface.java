package pagination;

public interface PageManagerViewInterface {
    void pageResponseData(Object response);

    void showLoading();

    void hideLoading();

    void shoErrorMessage(String errormsz);
}
