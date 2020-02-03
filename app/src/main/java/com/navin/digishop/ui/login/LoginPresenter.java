package com.navin.digishop.ui.login;

public class LoginPresenter  implements LoginInteractor.ILoginListener {


    ILoginView loginView;

    LoginInteractor loginInteractor;

    public LoginPresenter(ILoginView loginView, LoginInteractor loginInteractor) {

        this.loginView = loginView;
        this.loginInteractor = loginInteractor;

    }


    public void doLogin(String username, String password) {

        loginView.showProgressBar();

        loginInteractor.login(username,password,this);

    }


    @Override
    public void onUsernameError() {
        loginView.onUsernameError();
        loginView.hideProgressBar();
    }

    @Override
    public void onPasswordError() {

        loginView.onPasswordError();
        loginView.hideProgressBar();

    }

    @Override
    public void onSuccess() {

        loginView.hideProgressBar();
        loginView.navigateToHome();

    }

    @Override
    public void onLoginFailed() {

        loginView.hideProgressBar();
        loginView.onLoginFailed();

    }

    @Override
    public void onFailed() {

        loginView.hideProgressBar();
        loginView.onError();

    }
}
