package cn.fortrun.androidtestdemo;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * description
 *
 * @author tianyu
 * @create 2018.11.28 14:55
 * @since 1.0.0
 */
public class RxTools {
//    public class RxTools {
//        public static void asyncToSync() {
//            Func1<Scheduler, Scheduler> schedulerFunc = new Func1<Scheduler, Scheduler>() {
//                @Override
//                public Scheduler call(Scheduler scheduler) {
//                    return Schedulers.immediate();
//                }
//            };
//
//            RxAndroidSchedulersHook rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
//                @Override
//                public Scheduler getMainThreadScheduler() {
//                    return Schedulers.immediate();
//                }
//            };
//
//            RxJavaHooks.reset();
//            RxJavaHooks.setOnIOScheduler(schedulerFunc);
//            RxJavaHooks.setOnComputationScheduler(schedulerFunc);
//
//            RxAndroidPlugins .reset();
//            RxAndroidPlugins.registerSchedulersHook(rxAndroidSchedulersHook);
//        }
//    }

    /**
     * 单元测试的时候，利用RxJavaPlugins将io线程转换为trampoline
     * trampoline应该是立即执行的意思（待商榷），替代了Rx1的immediate。
     */
    public static void asyncToSync() {
        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }
}
