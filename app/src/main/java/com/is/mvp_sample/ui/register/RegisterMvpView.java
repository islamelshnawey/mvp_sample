package com.is.mvp_sample.ui.register;

import com.is.mvp_sample.ui.base.BaseMvpView;

/**
 * @author Islam
 * @date 10/11/2018
 */

public interface RegisterMvpView extends BaseMvpView {

    void inputsValidation();

    void onRegisterSuccess();

    void onRegisterError(String error);
}
