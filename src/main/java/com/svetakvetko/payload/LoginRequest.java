package com.svetakvetko.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String userLogin;

    @NotBlank
    private String password;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
