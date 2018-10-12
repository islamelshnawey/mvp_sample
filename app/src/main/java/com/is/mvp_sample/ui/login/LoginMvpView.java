package com.is.mvp_sample.ui.login;

import com.is.mvp_sample.ui.base.BaseMvpView;

/**
 * @author Islam
 * @date 10/11/2018
 */

public interface LoginMvpView extends BaseMvpView{

    void onLoginSuccess();

    void onLoginError(String error);

    void inputsValidation();


}
