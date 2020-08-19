package ps.ns.just_click_and_eat.network.utils;

public interface RequestListener<T> {
    void onSuccess(T data);

    void onFail(String message, int code);
}
