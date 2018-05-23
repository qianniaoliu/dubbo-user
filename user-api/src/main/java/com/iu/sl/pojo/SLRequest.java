package com.iu.sl.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 16:49
 */
public class SLRequest implements Serializable {
    private static final long serialVersionUID = 8911319318719939053L;
    private String loginid;
    private String password;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SLRequest{" +
                "loginid='" + loginid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
