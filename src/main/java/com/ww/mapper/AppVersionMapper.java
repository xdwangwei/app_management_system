package com.ww.mapper;

import com.ww.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {

    /**
     * 查出某App的历史版本信息集
     * @param app_id
     * @return
     */
    List<AppVersion> selectVersionInfoByAppId(@Param("app_id") Long app_id);
}