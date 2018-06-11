package com.iu.sl.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.iu.sl.api.UserService;
import com.iu.sl.contants.SLResponseContants;
import com.iu.sl.mapper.UserMapper;
import com.iu.sl.model.ResponseUser;
import com.iu.sl.model.User;
import com.iu.sl.pojo.SLRequest;
import com.iu.sl.pojo.SLResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/17 17:01
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public SLResponse doLogin(SLRequest slRequest) {
        User user = userMapper.selectByUserName(slRequest.getLoginid());
        ResponseUser slResponse = new ResponseUser();
        if(user != null){
            slResponse.setId(user.getId());
            slResponse.setUsername(user.getUsername());
            slResponse.setPassword(user.getPassword());
            slResponse.setMsg("用户验证成功!");
            slResponse.setCode(SLResponseContants.LOGIN_SUCCESS);
        }else{
            slResponse.setMsg("用户验证失败!");
            slResponse.setCode(SLResponseContants.LOGIN_ERROR);
        }
        return slResponse;
    }

    @Override
    public SLResponse doRegister(SLRequest slRequest) {

        return null;
    }
}
