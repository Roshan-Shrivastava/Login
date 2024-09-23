package com.roshan.login.Controller.Login;


//import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    private int id;
    private String username;
    private String password;
    private String custType;

}
