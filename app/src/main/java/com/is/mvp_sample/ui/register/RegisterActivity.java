package com.is.mvp_sample.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.is.mvp_sample.R;
import com.is.mvp_sample.ui.base.BaseActivity;
import com.is.mvp_sample.ui.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Islam Elshnawey
 */
public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtUserName)
    EditText edtUserName;
    @BindView(R.id.edtPassword)
    EditText edtPassword;

    private RegisterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mPresenter = new RegisterPresenter(RegisterActivity.this);
    }

    @OnClick({R.id.signIn, R.id.signUp, R.id.btnSignUp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signIn:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
            case R.id.signUp:

                break;
            case R.id.btnSignUp:
                inputsValidation();
                break;
            default:

                break;
        }
    }

    @Override
    public void inputsValidation() {
        mPresenter.validateInputs(edtEmail, edtUserName,edtPassword);
    }

    @Override
    public void onRegisterSuccess() {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    @Override
    public void onRegisterError(String error) {

    }
}
