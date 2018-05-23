package com.iu.sl.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.iu.sl.api.UserService;
import com.iu.sl.pojo.SLRequest;
import com.iu.sl.pojo.SLResponse;
import com.iu.sl.serviceimpl.JwtTokenService;
import com.iu.sl.utils.AuthJwtToken;
import com.iu.sl.utils.JwtInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 17:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public SLResponse doLogin(SLRequest slRequest) {
        SLResponse slResponse = new SLResponse();
        String token = slRequest.getToken();
        if(token == null) {
            if (slRequest.getLoginid() != null && slRequest.getPassword() != null) {
                slResponse.setCode("100");
                slResponse.setMsg("验证成功!");
                JwtInfo jwtInfo = new JwtInfo(slRequest.getLoginid());
                slResponse.setToken(jwtTokenService.generatorToken(jwtInfo));
            } else {
                slResponse.setCode("101");
                slResponse.setMsg("密码错误!");
                return slResponse;
            }
        }else{
            JwtInfo jwtInfo = jwtTokenService.getTokenInfo(token);
            boolean isAuth = AuthJwtToken.valiToken(jwtInfo,slRequest.getLoginid());
            if(isAuth){
                slResponse.setCode("100");
                slResponse.setMsg("验证成功!");
            }else{
                slResponse.setCode("102");
                slResponse.setMsg("验证失败!");
            }
        }

        return slResponse;
    }

    @Override
    public SLResponse doRegister(SLRequest slRequest) {

        return null;
    }
}
