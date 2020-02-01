package com.navin.digishop.models;

public interface IResponseMessage<T> {

    public void onSuccess(T response);
    public void onFailuer(String errorMessage);

}
