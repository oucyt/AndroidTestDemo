package cn.fortrun.androidtestdemo.test.dagger2;

import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import cn.fortrun.androidtestdemo.R;
import cn.fortrun.androidtestdemo.dagger2.LoginActivity;
import cn.fortrun.androidtestdemo.dagger2.LoginPresenter;
import cn.fortrun.androidtestdemo.dagger2.UserManager;
import cn.fortrun.androidtestdemo.mockito.PasswordValidator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by xiaochuang on 5/14/16.
 */
@RunWith(RobolectricTestRunner.class)
public class LoginActivityTest {

    /**
     * 测试目的:验证登录参数是否正确
     */
    @Test
    public void testActivityStart() {
        TestUtils.setupDagger();
        LoginPresenter mockLoginPresenter = mock(LoginPresenter.class);
        Mockito.when(TestUtils.appModule
                .provideLoginPresenter(any(UserManager.class), any(PasswordValidator.class)))
                .thenReturn(mockLoginPresenter);

        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("xiaochuang is handsome");
        loginActivity.findViewById(R.id.login).performClick();

        verify(mockLoginPresenter).login("xiaochuang", "xiaochuang is handsome");
    }
}