package com.roshan.login.Controller.Login;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user_detail")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String custType;
}
