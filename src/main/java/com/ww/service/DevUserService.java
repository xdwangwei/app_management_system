package com.ww.service;

import com.ww.pojo.DevUser;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/6/30 星期日 21:20
 **/
public interface DevUserService {

    /**
     * 根据账号密码查询用户信息
     * @param devUser
     * @return
     */
    DevUser login(DevUser devUser);

}
