package com.burakkoc.restaurantbooking.utils.results;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult(T data) {
        super(true, data);
    }

    public SuccessDataResult(T data,String message) {
        super(true, data, message);
    }
}
