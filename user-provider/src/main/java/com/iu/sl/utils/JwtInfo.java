package com.iu.sl.utils;


/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 22:26
 */
public class JwtInfo{
    private String uid;

    public JwtInfo(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
