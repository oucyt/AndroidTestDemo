package cn.fortrun.androidtestdemo.what;


import cn.fortrun.androidtestdemo.groupshare.NetworkCallback;

/**
 * Created by xiaochuang on 4/25/16.
 */
public class UserManager {
    public void performLogin(String username, String password) {
        //perform login and post LoginResult event
    }

    public void performLogin(String username, String password, NetworkCallback networkCallback) {
        //perform login and notify networkCallback
    }
}
