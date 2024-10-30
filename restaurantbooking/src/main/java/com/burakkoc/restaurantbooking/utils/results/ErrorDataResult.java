package com.burakkoc.restaurantbooking.utils.results;

public class ErrorDataResult<T> extends DataResult<T>{

    public ErrorDataResult(T data) {
        super(false, data);
    }

    public ErrorDataResult(T data, String message) {
        super(false, data, message);
    }
}
