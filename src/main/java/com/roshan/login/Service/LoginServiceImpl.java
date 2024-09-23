package com.roshan.login.Service;

import com.roshan.login.Controller.Login.Login;
import com.roshan.login.Controller.Login.LoginEntity;
import com.roshan.login.Repository.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;


    @Override
    public String readLoginStatus(String username, String password,String userType) {
        // Fetch the user by username using the custom method
//        Optional<LoginEntity> logUser = loginRepository.findByUsername(username);
        Optional<LoginEntity> logUser=loginRepository.findByCustTypeAndUsernameAndPassword(userType,username,password);
            if (logUser.isPresent()  ) {
                    return "Login Successfully";
            } else {
                return "Incorrect Username Or Password";
            }
    }

    @Override
    public String createUserDetail(Login login) {
        LoginEntity loginEntity=new LoginEntity();
        BeanUtils.copyProperties(login,loginEntity);
        loginRepository.save(loginEntity);
        return "Saved SuccessFully";
    }
}
