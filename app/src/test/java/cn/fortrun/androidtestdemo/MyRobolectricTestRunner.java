package cn.fortrun.androidtestdemo;

import org.junit.runners.model.InitializationError;
import org.robolectric.RoboSettings;
import org.robolectric.RobolectricTestRunner;

/**
 * description
 *
 * @author tianyu
 * @create 2018.11.24 23:18
 * @since 1.0.0
 */public class MyRobolectricTestRunner extends RobolectricTestRunner {
    public MyRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);

        // 从源码知道MavenDependencyResolver默认以RoboSettings的repositoryUrl和repositoryId为默认值，因此只需要对RoboSetting进行赋值即可
        RoboSettings.setMavenRepositoryId("alimaven");
        RoboSettings.setMavenRepositoryUrl("http://maven.aliyun.com/nexus/content/groups/public/");
    }
}
