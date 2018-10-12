package com.is.mvp_sample.ui.login;

import android.util.Log;
import android.widget.EditText;

import com.is.mvp_sample.data.remote.ApiClient;
import com.is.mvp_sample.data.remote.ApiInterface;
import com.is.mvp_sample.data.remote.pojo.LoginPojoModel;
import com.is.mvp_sample.ui.base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * @author Islam
 * @date 10/11/2018
 */

public class LoginPresenter extends BasePresenter<LoginMvpView> implements LoginMvpPresenter {


    private static final String TAG = "LoginPresenter";

    private LoginMvpView mvpView;

    public LoginPresenter(LoginMvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void validateInputs(EditText edtEmail, EditText edtPassword) {

        // collecting user data
        String email = edtEmail.getText().toString().toLowerCase().trim();
        String password = edtPassword.getText().toString();

        if (email.isEmpty()) {
            mvpView.requiredField(edtEmail);
        } else if (password.isEmpty()) {
            mvpView.requiredField(edtPassword);
        } else {
            login(email, password);
        }
    }

    public void login(String email, String password) {
        mvpView.showLoading();
        getObservable(email, password).subscribeWith(getObserver());
    }

    /**
     * @param email
     * @param password
     * @return
     */
    private Observable getObservable(String email, String password) {

        return ApiClient.getRetrofit().create(ApiInterface.class)
                .login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * @return
     */
    private DisposableObserver<LoginPojoModel> getObserver() {

        return new DisposableObserver<LoginPojoModel>() {
            @Override
            public void onNext(LoginPojoModel loginPojoModel) {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error" + e);
                mvpView.onLoginError(String.valueOf(e));
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
                mvpView.hideLoading();
                mvpView.onLoginSuccess();
            }
        };

    }

}
