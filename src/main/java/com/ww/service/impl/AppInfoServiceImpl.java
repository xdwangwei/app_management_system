package com.ww.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ww.mapper.AppInfoMapper;
import com.ww.pojo.AppInfo;
import com.ww.pojo.SelectDTO;
import com.ww.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/4 星期四 18:36
 **/
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public PageInfo<AppInfo> selectPageByDevId(Long devId, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        SelectDTO selectDTO = new SelectDTO();
        selectDTO.setDevId(devId);
        List<AppInfo> appInfos = appInfoMapper.selectPageApps(selectDTO, pageInfo);
        return new PageInfo<>(appInfos);
    }

    @Override
    public PageInfo<AppInfo> selectPageApps(SelectDTO selectDTO, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<AppInfo> appInfos = appInfoMapper.selectPageApps(selectDTO, pageInfo);
        return new PageInfo<>(appInfos);
    }

    @Override
    public int insertAppInfo(AppInfo appInfo) {
        // 设置默认值
        Date d = new Date();
        appInfo.setCreationDate(d);
        appInfo.setUpdateDate(d);
        appInfo.setModifyDate(d);
        appInfo.setDownloads(0L);
        return appInfoMapper.insertAppInfo(appInfo);
    }

    @Override
    public int deleteAppInfoById(Long appId) {
        return appInfoMapper.deleteAppInfoById(appId);
    }

    @Override
    public AppInfo selectAppInfoById(Long appId) {
        return appInfoMapper.selectAppInfoById(appId);
    }

    @Override
    public int updateAppInfo(AppInfo appInfo) {
        return appInfoMapper.updateAppInfo(appInfo);
    }

    @Override
    public int updateAppStatusById(Long status, Long appId) {
        return appInfoMapper.updateAppStatusById(status, appId);
    }
}
