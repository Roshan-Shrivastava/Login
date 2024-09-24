package com.roshan.login.Service;

import com.roshan.login.Controller.Login.Login;
import com.roshan.login.Controller.Login.LoginEntity;
import com.roshan.login.Repository.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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
        Optional<LoginEntity> logUser=loginRepository.findByUsername(login.getUsername());
        if(!logUser.isPresent()){
            BeanUtils.copyProperties(login,loginEntity);
            loginRepository.save(loginEntity);
            return "Saved SuccessFully";
        }else{
            return "User is Exist";
        }

    }

    @Override
    public Boolean checkUser(String username) {
        Optional<String> checkUser =loginRepository.findDistinctByUsername(username);

        if(checkUser.isPresent())
            return true;
        else
            return false;
    }

    @Override
    public String changePassword(int id ,String newPassword,String reEnterPassword){
        try{


            if(newPassword.equalsIgnoreCase(reEnterPassword)){
                LoginEntity log=loginRepository.findById(Long.valueOf(id)).get();

                if(!log.getPassword().equalsIgnoreCase(newPassword)){
                    log.setPassword(newPassword);
                    log.setUsername(log.getUsername());
                    log.setCustType(log.getCustType());
                    loginRepository.save(log);
                    return "Password has been Changed";
                }else{
                    return "Old password or New Password is same";
                }
            }
            else {
                return "New Password or Re-Enter Password Doesn't Match";
            }
        } catch (Exception e) {
            Throwable cause = e.getCause();
            System.out.println("Actual exception: " + cause.getMessage());
            return "Actual exception: " + cause.getMessage();
        }


    }
}
