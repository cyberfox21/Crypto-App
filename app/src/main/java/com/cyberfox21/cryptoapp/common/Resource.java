package com.cyberfox21.cryptoapp.common;

/**
 * @author t.shkolnik
 */
public abstract class Resource<T> {

    T data = null;

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    String message = null;

    public final static class Success<T> extends Resource<T> {

        public Success(T data) {
            this.data = data;
        }
    }

    public final static class Error<T> extends Resource<T> {

        public Error(String message) {
            this.message = message;
        }
    }

    public final static class Loading<T> extends Resource<T> {}
}
