package com.is.mvp_sample.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.is.mvp_sample.R;
import com.is.mvp_sample.ui.base.BaseActivity;
import com.is.mvp_sample.ui.main.MainActivity;
import com.is.mvp_sample.ui.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Islam Elshnawey
 */
public class LoginActivity extends BaseActivity implements LoginMvpView {

    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPassword)
    EditText edtPassword;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mPresenter = new LoginPresenter(LoginActivity.this);

    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void onLoginError(String error) {

    }

    @OnClick({R.id.signIn, R.id.signUp, R.id.btnSignIn, R.id.actionRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signIn:

                break;
            case R.id.signUp:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.btnSignIn:
                // make  validations
                inputsValidation();
                break;
            case R.id.actionRegister:

                break;
            default:

                break;
        }
    }

    @Override
    public void inputsValidation() {
        mPresenter.validateInputs(edtEmail, edtPassword);
    }
}
