package multithreading.debounce;

public interface Callback<T> {
    void call(T t);
}
