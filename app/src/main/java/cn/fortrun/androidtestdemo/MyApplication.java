package cn.fortrun.androidtestdemo;

import android.app.Application;

import com.chriszou.auttutorial.dagger2.AppModule;
import com.chriszou.auttutorial.dagger2.DaggerAppComponent;

import cn.fortrun.androidtestdemo.dagger2.AppComponent;
import cn.fortrun.androidtestdemo.dagger2.ComponentHolder;

/**
 * Created by xiaochuang on 5/14/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        ComponentHolder.setAppComponent(appComponent);
    }
}
