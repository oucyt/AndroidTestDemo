package cn.fortrun.androidtestdemo.test.daggermock;

import org.robolectric.RuntimeEnvironment;

import cn.fortrun.androidtestdemo.dagger2.AppComponent;
import cn.fortrun.androidtestdemo.dagger2.AppModule;
import cn.fortrun.androidtestdemo.dagger2.ComponentHolder;
import it.cosenonjaviste.daggermock.DaggerMockRule;

/**
 * Created by xiaochuang on 7/24/16.
 */
public class DaggerRule extends DaggerMockRule<AppComponent> {
    public DaggerRule() {
        //告诉DaggerMock要build什么样的Component，使用哪个module
        super(AppComponent.class, new AppModule(RuntimeEnvironment.application));
        //告诉DaggerMock把build好的Component放到哪
        set(new ComponentSetter<AppComponent>() {
            @Override
            public void setComponent(AppComponent appComponent) {
                ComponentHolder.setAppComponent(appComponent);
            }
        });
    }
}
