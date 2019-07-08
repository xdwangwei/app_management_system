package com.ww.service;

import com.ww.pojo.DataDictionary;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/5 星期五 08:38
 **/
public interface DataDictionaryService {
    /**
     * 查询所有app平台信息
     * @return
     */
    List<DataDictionary> selectAllFlatform();

    /**
     * 查询所有app状态信息
     * @return
     */
    List<DataDictionary> selectAllAppStatus();

}
