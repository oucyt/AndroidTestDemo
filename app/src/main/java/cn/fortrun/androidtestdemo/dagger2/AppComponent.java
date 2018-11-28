package cn.fortrun.androidtestdemo.dagger2;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xiaochuang on 5/14/16.
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    LoginPresenter loginPresenter();

    void inject(LoginActivity mainActivity);

    void inject( cn.fortrun.androidtestdemo.daggermock.LoginActivity loginActivity);
}
