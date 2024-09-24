package com.roshan.login.Service;

import com.roshan.login.Controller.Login.Login;

public interface LoginService {
    String readLoginStatus(String username,String password,String userType);
    String createUserDetail(Login login);
    Boolean checkUser(String username);
    String changePassword(int id,String newPassword,String reEnterPassword);

}
