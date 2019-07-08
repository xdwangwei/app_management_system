package com.ww.service.impl;

import com.ww.mapper.AppCategoryMapper;
import com.ww.pojo.AppCategory;
import com.ww.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/5 星期五 08:57
 **/
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> selectAllLevel1Category() {
        return appCategoryMapper.selectAllLevel1Category();
    }

    @Override
    public List<AppCategory> selectAllLeve2CategoryByLevelId(Long level1Id) {
        return appCategoryMapper.selectChildrenCategoryByParentId(level1Id);
    }

    @Override
    public List<AppCategory> selectAllLeve3CategoryByLeve2Id(Long level2Id) {
        return appCategoryMapper.selectChildrenCategoryByParentId(level2Id);
    }
}
