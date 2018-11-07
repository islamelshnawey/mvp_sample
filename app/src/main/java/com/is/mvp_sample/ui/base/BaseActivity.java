package com.is.mvp_sample.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.is.mvp_sample.R;
import com.is.mvp_sample.util.DialogUtils;

/**
 *
 * @author Islam
 * @date 10/12/2018
 */

public class BaseActivity extends AppCompatActivity implements BaseMvpView{

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = DialogUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    @Override
    public void requiredField(EditText editText) {
        editText.setError(getString(R.string.errRequiredField));

    }
}
