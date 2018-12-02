package cn.fortrun.androidtestdemo.async;


import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import cn.fortrun.androidtestdemo.rules.RxJava2Rule;
import io.reactivex.functions.Consumer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by xiaochuang on 8/7/16.
 */
//@RunWith(RobolectricTestRunner.class)
public class RepoModelTest {
    @Rule
    public   RxJava2Rule sSchedulersOverrideRule = new RxJava2Rule();

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
        model.loadRepos(new RepoModel.RepoCallback() {
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