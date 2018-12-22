package cn.fortrun.androidtestdemo.my;

import android.app.Activity;
import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import cn.fortrun.androidtestdemo.what.MainActivity;

import static org.junit.Assert.assertEquals;

/**
 * description
 * https://blog.csdn.net/shensky711/article/details/53561172
 * http://blog.hanschen.site/2016/07/12/mock-web-server.html
 *https://blog.csdn.net/qq_17766199/article/details/78710177
 * @author 87627
 * @create 2018.12.17 19:55
 * @since 1.0.0
 */

@RunWith(RobolectricTestRunner.class)
public class ActivityTest {


    @Test
    public void testActivity() {
//        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
//        controller.create();
//        MainActivity activity = controller.get();
//        Assert.assertEquals(7, activity.i);



//        // 默认会调用Activity的生命周期: onCreate->onStart->onResume
//        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
//        // 触发按钮点击
//        activity.findViewById(R.id.login).performClick();
//        // 获取对应的Shadow类
//        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
//        // 借助Shadow类获取启动下一Activity的Intent
//        Intent nextIntent = shadowActivity.getNextStartedActivity();
//        // 校验Intent的正确性
//        assertEquals(nextIntent.getComponent().getClassName(), LoginActivity.class.getName());



//        // 创建Activity控制器
//        ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class);
//        MainActivity activity = controller.get();
////        assertNull(activity.getLifecycle());
//
//        // 调用Activity的performCreate方法
//        controller.create();
//        System.out.println( activity.getLifecycle().getCurrentState().name());
//
//        // 调用Activity的performStart方法
//        controller.start();
//        System.out.println( activity.getLifecycle().getCurrentState().name());
//
//        // 调用Activity的performResume方法
//        controller.resume();
//        System.out.println( activity.getLifecycle().getCurrentState().name());
//
//        // 调用Activity的performPause方法
//        controller.pause();
//        System.out.println( activity.getLifecycle().getCurrentState().name());
//
//        // 调用Activity的performStop方法
//        controller.stop();
//        System.out.println( activity.getLifecycle().getCurrentState().name());
//
//        // 调用Activity的performRestart方法
//        controller.restart();
//        // 注意此处应该是onStart，因为performRestart不仅会调用restart，还会调用onStart
//        System.out.println( activity.getLifecycle().getCurrentState().name());
//
//        // 调用Activity的performDestroy方法
//        controller.destroy();
//        System.out.println( activity.getLifecycle().getCurrentState().name());


        Intent intent = new Intent();
        intent.putExtra("test", "HelloWorld");
//        Activity activity = Robolectric.buildActivity(MainActivity.class).(intent).create().get();

        assertEquals("HelloWorld", activity.getIntent().getExtras().getString("test"));

    }
}
