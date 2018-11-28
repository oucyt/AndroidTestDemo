package cn.fortrun.androidtestdemo.async;

import com.chriszou.auttutorial.RxTools;
import com.chriszou.auttutorial.async.RepoModel.RepoCallback;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by xiaochuang on 8/7/16.
 */
@RunWith(RobolectricTestRunner.class)
public class RepoModelTest {

    /**
     * https://stackoverflow.com/questions/24642049/android-testing-handler-postdelayed
     *
     * @throws Exception
     */
    @Test
    public void testLoadRepos() throws Exception {
        RepoModel model = new RepoModel();
        final List<Repo> result = new ArrayList<>();
        final CountDownLatch latch = new CountDownLatch(1);
        model.loadRepos(new RepoCallback() {
            @Override
            public void onSuccess(List<Repo> repos) {
                result.addAll(repos);
                latch.countDown();
            }

            @Override
            public void onFailure(int code, String msg) {
                fail();
            }
        });
        latch.await();
        assertEquals(1, result.size());
        latch.await(2, TimeUnit.SECONDS);
    }

    @Test
    public void testLoadReposInRx() {
//        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
//            @Override
//            public Scheduler getIOScheduler() {
//                return Schedulers.immediate();
//            }
//        });
//        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
//            @Override
//            public Scheduler getMainThreadScheduler() {
//                return Schedulers.immediate();
//            }
//        });
        RxTools.asyncToSync();
        RepoModel model = new RepoModel();
        final List<Repo> result = new ArrayList<>();
        model.loadRepos()
                .subscribe(new Consumer<List<Repo>>() {
                    @Override
                    public void accept(List<Repo> repos) throws Exception {
                        result.addAll(repos);
                    }
                });
        assertEquals(1, result.size());
    }
}