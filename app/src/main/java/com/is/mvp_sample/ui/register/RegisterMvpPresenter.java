package com.is.mvp_sample.ui.register;

import android.widget.EditText;

/**
 *
 * @author Islam
 * @date 10/11/2018
 */

public interface RegisterMvpPresenter {

    void validateInputs(EditText email,EditText userName, EditText password);

}
