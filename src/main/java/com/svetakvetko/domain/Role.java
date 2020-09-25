package com.svetakvetko.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private long id;

    private String roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return getRoleName();
    }
}
