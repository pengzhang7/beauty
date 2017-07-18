package com.beauty.basic.domain;

/**
 * Created by pengzhang7.
 */
public class HttpMessage<T> {
    private T content;

    private String message;

    public HttpMessage(T content, String message){
        this.content = content;
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
