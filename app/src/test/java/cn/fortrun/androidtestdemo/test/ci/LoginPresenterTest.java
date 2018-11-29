package cn.fortrun.androidtestdemo.test.ci;


import org.junit.Test;
import org.mockito.Mockito;

import cn.fortrun.androidtestdemo.di.LoginPresenter;
import cn.fortrun.androidtestdemo.what.UserManager;

/**
 * Created by xiaochuang on 5/7/16.
 */
public class LoginPresenterTest {
    /**
     * 测试目的：UserManager#performLogin是否得到了调用
     */
    @Test
    public void testLogin() {
        // 所有的login逻辑都是在UserManager完成,先mock一个出来
        UserManager mockUserManager = Mockito.mock(UserManager.class);

        // 参数注入
        LoginPresenter presenter = new LoginPresenter(mockUserManager);

        // 调用presenter#login
        presenter.login("xiaochuang", "xiaochuang password");

        // 验证
        Mockito.verify(mockUserManager).performLogin("xiaochuang", "xiaochuang password");
    }
}
