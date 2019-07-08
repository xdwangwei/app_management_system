package com.ww.mapper;

import com.ww.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {

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