package com.ww.service.impl;

import com.ww.mapper.DataDictionaryMapper;
import com.ww.pojo.DataDictionary;
import com.ww.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/5 星期五 08:39
 **/
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> selectAllFlatform() {
        return dataDictionaryMapper.selectAllFlatform();
    }

    @Override
    public List<DataDictionary> selectAllAppStatus() {
        return dataDictionaryMapper.selectAllAppStatus();
    }
}
