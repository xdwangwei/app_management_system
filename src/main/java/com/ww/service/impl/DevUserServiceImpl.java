package com.ww.service.impl;

import com.ww.mapper.DevUserMapper;
import com.ww.pojo.DevUser;
import com.ww.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/6/30 星期日 21:34
 **/
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser login(DevUser devUser) {

        return devUserMapper.selectByCodeAndPwd(devUser);
    }
}
