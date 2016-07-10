package com.eekhout.reporteer.login;

import com.eekhout.reporteer.login.events.LoginEvent;

/**
 * Created by Alexander on 27-06-2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
