package com.ww.mapper;

import com.ww.pojo.DevUser;

public interface DevUserMapper {

    DevUser selectByCodeAndPwd(DevUser devUser);

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}