package com.cyberfox21.cryptoapp.common;

/**
 * @author t.shkolnik
 */
public class Resource<T> {

    T data = null;

    String message = null;

    public Resource() {
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public final static class Success<T> extends Resource<T> {

        public Success(T data) {
            super();
            this.data = data;
        }

    }

    public final static class Error<T> extends Resource<T> {

        public Error(String message) {
            super();
            this.message = message;
        }
    }

    public final static class Loading<T> extends Resource<T> {
        public Loading() {
            super();
        }
    }
}
