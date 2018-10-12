package com.is.mvp_sample.ui.register;

import android.util.Log;
import android.widget.EditText;

import com.is.mvp_sample.data.remote.ApiClient;
import com.is.mvp_sample.data.remote.ApiInterface;
import com.is.mvp_sample.data.remote.pojo.RegisterPojoModel;
import com.is.mvp_sample.ui.base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Islam
 * @date 10/11/2018
 */

public class RegisterPresenter extends BasePresenter<RegisterMvpView> implements RegisterMvpPresenter {


    private static final String TAG = "RegisterPresenter";
    private RegisterMvpView mvpView;

    public RegisterPresenter(RegisterMvpView mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void validateInputs(EditText edtEmail, EditText edtUserName, EditText edtPassword) {

        // collecting user data
        String email = edtEmail.getText().toString().toLowerCase().trim();
        String userName = edtUserName.getText().toString().toLowerCase().trim();
        String password = edtPassword.getText().toString();

        if (email.isEmpty()) {
            mvpView.requiredField(edtEmail);
        } else if (password.isEmpty()) {
            mvpView.requiredField(edtPassword);
        } else {
            register(email, userName, password);
        }
    }

    private void register(String email, String userName, String password) {

        mvpView.showLoading();
        getObservable(email,userName, password).subscribeWith(getObserver());
    }

    /**
     * @param email
     * @param password
     * @return
     */
    private Observable getObservable(String email,String userName ,String password) {

        return ApiClient.getRetrofit().create(ApiInterface.class)
                .register(email, userName,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * @return
     */
    private DisposableObserver<RegisterPojoModel > getObserver() {

        return new DisposableObserver<RegisterPojoModel>() {
            @Override
            public void onNext(RegisterPojoModel loginPojoModel) {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error" + e);
                mvpView.onRegisterError(String.valueOf(e));
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
                mvpView.hideLoading();
                mvpView.onRegisterSuccess();
            }
        };

    }


}
