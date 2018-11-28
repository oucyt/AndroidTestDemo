package cn.fortrun.androidtestdemo.mockitoannotations;

import javax.inject.Inject;

import cn.fortrun.androidtestdemo.dagger2.UserManager;
import cn.fortrun.androidtestdemo.mockito.PasswordValidator;

/**
 * Created by xiaochuang on 4/29/16.
 */
public class LoginPresenter {
    private final UserManager mUserManager;
    private final PasswordValidator mPasswordValidator;

    public LoginPresenter() {
        this(null, null);
    }

    @Inject
    public LoginPresenter(UserManager userManager, PasswordValidator passwordValidator) {
        this.mUserManager = userManager;
        this.mPasswordValidator = passwordValidator;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) return;
        if (!mPasswordValidator.verifyPassword(password)) return;

        mUserManager.performLogin(username, password);
    }

}
