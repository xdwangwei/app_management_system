package com.ww.service.impl;

import com.ww.mapper.BackendUserMapper;
import com.ww.pojo.BackendUser;
import com.ww.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/6/30 星期日 21:34
 **/
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {

    @Autowired
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser login(BackendUser backendUser) {

        return backendUserMapper.selectByCodeAndPwd(backendUser);
    }
}
