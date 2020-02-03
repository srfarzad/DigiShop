package com.navin.digishop.ui.login;

public interface ILoginView {

    public void showProgressBar();

    public void hideProgressBar();

    public void onUsernameError();

    public void onPasswordError();

    public void onError();

    public void navigateToHome();

    public void onLoginFailed();




}
