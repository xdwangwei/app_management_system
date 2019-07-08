package com.ww.mapper;

import com.ww.pojo.BackendUser;

public interface BackendUserMapper {

    BackendUser selectByCodeAndPwd(BackendUser backendUser);

    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int updateByPrimaryKeySelective(BackendUser record);

}