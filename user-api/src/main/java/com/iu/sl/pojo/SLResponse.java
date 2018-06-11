package com.iu.sl.pojo;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 16:49
 */
public class SLResponse implements Serializable {
    private static final long serialVersionUID = -7610920711494532603L;
    private String code;
    private String msg;
    private String token;



    public SLResponse(){}

    public SLResponse(String code, String msg, String token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SLResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
