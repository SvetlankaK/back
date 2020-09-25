package com.svetakvetko.payload;

import com.svetakvetko.domain.Role;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String userLogin;
    private String name;
    private List<Role> roles;

    public JwtResponse(String accessToken, Long id, String name, String userLogin, List<Role> roles) {
        this.token = accessToken;
        this.name = name;
        this.id = id;
        this.userLogin = userLogin;
        this.roles = roles;

    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
