package cn.fortrun.androidtestdemo.test.dagger2;

import android.content.SharedPreferences;

import com.chriszou.auttutorial.dagger2.ComponentHolder;
import com.chriszou.auttutorial.dagger2.LoginPresenter;
import com.chriszou.auttutorial.dagger2.UserApiService;
import com.chriszou.auttutorial.dagger2.UserManager;
import com.chriszou.auttutorial.mockito.PasswordValidator;
import com.chriszou.auttutorial.test.groupshare.JSpec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

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