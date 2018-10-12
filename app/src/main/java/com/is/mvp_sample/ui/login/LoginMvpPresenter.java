package com.is.mvp_sample.ui.login;

import android.widget.EditText;

/**
 * Created by Islam on 10/11/2018.
 */

public interface LoginMvpPresenter {


    void validateInputs(EditText email, EditText password);

}
