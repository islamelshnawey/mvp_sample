package com.is.mvp_sample.ui.base;

/**
 * Created by Islam on 10/12/2018.
 */

public class BasePresenter<V> implements BaseMvpPresenter {

    protected V view;

    public void attachView(V view) {
        this.view = view;
    }
}
