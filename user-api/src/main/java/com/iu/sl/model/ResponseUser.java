package com.iu.sl.model;

import com.iu.sl.pojo.SLResponse;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/6/8 12:50
 */
public class ResponseUser extends SLResponse implements Serializable {
    private static final long serialVersionUID = -8436499155028879101L;

    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
