package com.ww.service;

import com.github.pagehelper.PageInfo;
import com.ww.pojo.AppInfo;
import com.ww.pojo.SelectDTO;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/4 星期四 18:36
 **/
public interface AppInfoService {
    /**
     * 根据页面号，页面大小，去查找devId对应的开发者开发的app信息列表
     * @param devId
     * @param pageInfo
     * @return
     */
    PageInfo<AppInfo> selectPageByDevId(Long devId, PageInfo pageInfo);

    /**
     * 根据封装后的查询条件去查找指定页面大小的记录
     * @param selectDTO
     * @param pageInfo
     * @return
     */
    PageInfo<AppInfo> selectPageApps(SelectDTO selectDTO, PageInfo pageInfo);

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
    int updateAppStatusById(Long status, Long appId);
}
