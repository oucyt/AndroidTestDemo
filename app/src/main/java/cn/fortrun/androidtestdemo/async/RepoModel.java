package cn.fortrun.androidtestdemo.async;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xiaochuang on 8/6/16.
 */
public class RepoModel {
//    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    public RepoModel() {
    }

    public Observable<List<Repo>> loadRepos() {
        return Observable.create(new ObservableOnSubscribe<List<Repo>>() {
            @Override
            public void subscribe(ObservableEmitter<List<Repo>> emitter) throws Exception {
                try {
                    //Imagine you're getting repos from network or database
                    Thread.sleep(2000);
                    final List<Repo> repos = new ArrayList<>();
                    repos.add(new Repo("android-unit-testing-tutorial", "A repo that demos how to do android unit testing"));
                    if (!emitter.isDisposed()) {
                        emitter.onNext(repos);
                        emitter.onComplete();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (!emitter.isDisposed()) {
                        emitter.onError(e);
                    }
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void loadRepos(final RepoCallback callback) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //Imagine you're getting repos from network or database
//                    Thread.sleep(1000);
//                    final List<Repo> repos = new ArrayList<>();
//                    repos.add(new Repo("android-unit-testing-tutorial", "A repo that demos how to do android unit testing"));
//                    mUiHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            callback.onSuccess(repos);
//                        }
//                    });
//                } catch (final InterruptedException e) {
//                    e.printStackTrace();
//                    mUiHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            callback.onFailure(500, e.getMessage());
//                        }
//                    });
//                }
//            }
//        }).start();


    }

    interface RepoCallback {
        void onSuccess(List<Repo> repos);

        void onFailure(int code, String msg);
    }
}
