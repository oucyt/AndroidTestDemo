package cn.fortrun.androidtestdemo.test.dagger2;


import org.robolectric.RuntimeEnvironment;

import cn.fortrun.androidtestdemo.dagger2.AppComponent;
import cn.fortrun.androidtestdemo.dagger2.AppModule;
import cn.fortrun.androidtestdemo.dagger2.ComponentHolder;
import cn.fortrun.androidtestdemo.dagger2.DaggerAppComponent;

import static org.mockito.Mockito.spy;

/**
 * Created by xiaochuang on 5/15/16.
 */
public class TestUtils {
        public static final AppModule appModule = spy(new AppModule(RuntimeEnvironment.application));
//    public static final AppModule appModule = spy(new AppModule(ApplicationProvider.getApplicationContext()));

    public static void setupDagger() {
        AppComponent appComponent = DaggerAppComponent.builder().appModule(appModule).build();
        ComponentHolder.setAppComponent(appComponent);
    }

}
