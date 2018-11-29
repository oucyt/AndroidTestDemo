package cn.fortrun.androidtestdemo.test.daggermock;

import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import cn.fortrun.androidtestdemo.R;
import cn.fortrun.androidtestdemo.dagger2.LoginActivity;
import cn.fortrun.androidtestdemo.dagger2.LoginPresenter;
import cn.fortrun.androidtestdemo.dagger2.UserManager;
import cn.fortrun.androidtestdemo.mockito.PasswordValidator;
import cn.fortrun.androidtestdemo.test.dagger2.TestUtils;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by xiaochuang on 5/14/16.
 */
@RunWith(RobolectricTestRunner.class)
public class LoginActivityTest {

    @Rule
    public DaggerRule daggerRule = new DaggerRule();

    /**
     * 通过DaggerRule,通过依赖注入的方式mock这个LoginPresenter
     */
    @Mock
    LoginPresenter loginPresenter;

    @Test
    public void testLogin_old_way() {
        // 构造好Component，LoginActivity会调用它
        TestUtils.setupDagger();
        Mockito.when(TestUtils.appModule.provideLoginPresenter(any(UserManager.class), any(PasswordValidator.class)))
                .thenReturn(loginPresenter);  //当mockAppModule的provideLoginPresenter()方法被调用时，让它返回mockLoginPresenter

        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("xiaochuang is handsome");
        loginActivity.findViewById(R.id.login).performClick();

        verify(loginPresenter).login("xiaochuang", "xiaochuang is handsome");
    }

    @Test
    public void testLogin_shinny_way() {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        ((EditText) loginActivity.findViewById(R.id.username)).setText("xiaochuang");
        ((EditText) loginActivity.findViewById(R.id.password)).setText("xiaochuang is handsome");
        loginActivity.findViewById(R.id.login).performClick();

        verify(loginPresenter).login("xiaochuang", "xiaochuang is handsome");
    }

}