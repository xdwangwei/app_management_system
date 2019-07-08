package com.ww.service;

import com.ww.pojo.BackendUser;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/6/30 星期日 21:20
 **/
public interface BackendUserService {

    /**
     * 根据账号密码查询用户信息
     * @param backendUser
     * @return
     */
    BackendUser login(BackendUser backendUser);

}
