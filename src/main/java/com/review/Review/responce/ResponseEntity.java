package com.review.Review.responce;

/**
 * @author z0049vuf on 10/7/2022
 */
public class ResponseEntity<T> {

    String message;
    Integer statusCode;
    T object;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
