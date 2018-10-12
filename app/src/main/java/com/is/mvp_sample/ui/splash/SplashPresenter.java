package com.is.mvp_sample.ui.splash;

/**
 * @author Islam
 * @date 10/11/2018
 */

public class SplashPresenter implements SplashMvpPresenter {

    SplashMvpView mvpView;

    public SplashPresenter(SplashMvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void decideNextActivity() {

        mvpView.openNextActivity();
    }
}
