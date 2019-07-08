package com.ww.mapper;

import com.github.pagehelper.PageInfo;
import com.ww.pojo.AppInfo;
import com.ww.pojo.SelectDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {

    /**
     * 根据封装后的查询条件查询app信息列表
     * @param selectDTO
     * @param pageInfo
     * @return
     */
    List<AppInfo> selectPageApps(@Param("selectDTO") SelectDTO selectDTO, PageInfo pageInfo);


    /**
     * 插入一条app应用信息
     * @param appInfo
     * @return
     */
    int insertAppInfo(AppInfo appInfo);

    /**
     * 根据app信息id删除此条记录
     * @param appId
     * @return
     */
    int deleteAppInfoById(Long appId);

    /**
     * 根据id查出此app的详细信息
     * @param appId
     * @return
     */
    AppInfo selectAppInfoById(Long appId);

    /**
     * 更新app信息
     * @param appInfo
     * @return
     */
    int updateAppInfo(AppInfo appInfo);

    /**
     * 根据id更改此app状态信息
     * @param status
     * @param appId
     * @return
     */
    int updateAppStatusById(@Param("status") Long status, @Param("appId") Long appId);
}