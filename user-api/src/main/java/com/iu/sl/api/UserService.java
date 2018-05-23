package com.iu.sl.api;

import com.iu.sl.pojo.SLRequest;
import com.iu.sl.pojo.SLResponse;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 16:46
 */
public interface UserService {

    SLResponse doLogin(SLRequest slRequest);

    SLResponse doRegister(SLRequest slRequest);


}
