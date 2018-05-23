package com.iu.sl.serviceimpl;

import com.iu.sl.utils.JwtInfo;
import com.iu.sl.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 22:46
 */
@Component
public class JwtTokenService {

    @Value("${jwt.expire}")
    private int expire;

    public String generatorToken(JwtInfo jwtInfo){
        return JwtTokenUtil.generatorToken(jwtInfo,expire);
    }

    public JwtInfo getTokenInfo(String token){
        return JwtTokenUtil.getToken(token);
    }
}
