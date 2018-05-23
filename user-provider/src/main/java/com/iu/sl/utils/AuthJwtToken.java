package com.iu.sl.utils;

import com.iu.sl.pojo.SLResponse;
import com.iu.sl.serviceimpl.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/18 9:37
 */
public class AuthJwtToken {


    public static boolean valiToken(JwtInfo jwtInfo, String uid){
        if(uid.equals(jwtInfo.getUid())){
            return true;
        }
        return false;
    }
}
