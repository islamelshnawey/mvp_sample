package com.is.mvp_sample.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.is.mvp_sample.R;
import com.is.mvp_sample.ui.login.LoginActivity;

/**
 * @author Islam Elshnawey
 */
public class SplashActivity extends AppCompatActivity implements SplashMvpView {

    SplashPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenter(SplashActivity.this);

        new Handler().postDelayed(new handler(), 3000);


    }

    @Override
    public void openNextActivity() {

        startActivity(new Intent(SplashActivity.this , LoginActivity.class));
    }


    private class handler implements Runnable {
        @Override
        public void run() {
            mPresenter.decideNextActivity();
        }
    }
}
