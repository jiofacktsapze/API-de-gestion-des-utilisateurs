package com.userManagment.dto;

import com.userManagment.model.Roles;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Roles role;
}
