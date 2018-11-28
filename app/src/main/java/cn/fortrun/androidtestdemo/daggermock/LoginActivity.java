package cn.fortrun.androidtestdemo.daggermock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import javax.inject.Inject;

import cn.fortrun.androidtestdemo.dagger2.ComponentHolder;
import cn.fortrun.androidtestdemo.dagger2.LoginPresenter;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComponentHolder.getAppComponent().inject(this);

        findViewById(R.id.login).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                mLoginPresenter.login(username, password);
            }
        });
    }


}
