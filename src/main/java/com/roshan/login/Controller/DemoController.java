package com.roshan.login.Controller;


import com.roshan.login.Controller.Login.Login;
import com.roshan.login.Repository.LoginRepository;
import com.roshan.login.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class DemoController {

    List<Login> login=new ArrayList<>();

    @Autowired
    LoginService loginService;

    @GetMapping("login/admin/{username}/{password}")
    public String readLoginStatus(@PathVariable String username,@PathVariable String password){
        return loginService.readLoginStatus(username, password,"Admin");
    }
    @GetMapping("login/customer/{username}/{password}")
    public String readCustomerLogin(@PathVariable String username,@PathVariable String password){
        return loginService.readLoginStatus(username, password, "Customer");
    }
    @PostMapping("login/create")
    public String createUser(@RequestBody Login login){
        return loginService.createUserDetail(login);
    }


}
