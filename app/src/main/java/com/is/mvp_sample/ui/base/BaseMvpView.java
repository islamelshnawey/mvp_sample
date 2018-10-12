package com.is.mvp_sample.ui.base;

import android.widget.EditText;

/**
 * Created by Islam on 10/12/2018.
 */

public interface BaseMvpView {

    void showToast(String message);

    void showLoading();

    void hideLoading();

    void requiredField(EditText editText);
}
