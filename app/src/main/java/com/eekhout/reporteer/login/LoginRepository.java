package com.eekhout.reporteer.login;

/**
 * Created by Alexander on 27-06-2016.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
