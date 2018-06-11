package com.iu.sl.pojo.blog;

import com.iu.sl.pojo.SLResponse;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/5/31 23:45
 */
public class RedisSLResponse<T> extends SLResponse implements Serializable {

    private static final long serialVersionUID = 1447090032882785326L;

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
