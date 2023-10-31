package pagination;

public class PaginationAPIResponse {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;

    private int responseType = ERROR;
    private Object response = new Exception("No Operation Operated!!!!");

    private PaginationAPIResponse() {
    }

    public PaginationAPIResponse(int responseType, Object response) {
        this.responseType = responseType;
        this.response = response;
    }

    public int getResponseType() {
        return responseType;
    }

    public void setResponseType(int responseType) {
        this.responseType = responseType;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

}
