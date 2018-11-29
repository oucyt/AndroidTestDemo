package cn.fortrun.androidtestdemo.test.dagger2;

import android.content.SharedPreferences;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import cn.fortrun.androidtestdemo.dagger2.ComponentHolder;
import cn.fortrun.androidtestdemo.dagger2.LoginPresenter;
import cn.fortrun.androidtestdemo.dagger2.UserApiService;
import cn.fortrun.androidtestdemo.dagger2.UserManager;
import cn.fortrun.androidtestdemo.mockito.PasswordValidator;
import cn.fortrun.androidtestdemo.test.groupshare.JSpec;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by xiaochuang on 5/15/16.
 */
@RunWith(RobolectricTestRunner.class)
public class LoginPresenterTest {

    @Test
    public void testLogin_daggerVersion() throws Exception {
        TestUtils.setupDagger();
        UserManager mockUserManager = mock(UserManager.class);
        Mockito.when(TestUtils.appModule.provideUserManager(any(SharedPreferences.class), any(UserApiService.class)))
                .thenReturn(mockUserManager);

        LoginPresenter presenter = ComponentHolder.getAppComponent().loginPresenter();
        presenter.login("xiaochuang", "xiaochuang is handsome");

        verify(mockUserManager).performLogin("xiaochuang", "xiaochuang is handsome");
    }

    @Test
    @JSpec(desc = "should fail for mock is not used")
    public void testLogin() {
        UserManager mockUserManager = mock(UserManager.class);
        LoginPresenter presenter = new LoginPresenter(mockUserManager, new PasswordValidator());//因为这里我们不verify PasswordValidator，所以不需要mock这个。

        presenter.login("xiaochuang", "xiaochuang is handsome");

        verify(mockUserManager).performLogin("xiaochuang", "xiaochuang is handsome");
    }
}