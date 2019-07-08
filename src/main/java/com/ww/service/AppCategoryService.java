package com.ww.service;

import com.ww.pojo.AppCategory;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/5 星期五 08:53
 **/
public interface AppCategoryService {

    /**
     * 查询出所有一级分类信息
     * @return
     */
    List<AppCategory> selectAllLevel1Category();

    /**
     * 根据一级分类id查询出其下所有二级分类信息
     * @return
     */
    List<AppCategory> selectAllLeve2CategoryByLevelId(Long level1Id);

    /**
     * 根据二级分类id查询出其下所有三级分类信息
     * @return
     */
    List<AppCategory> selectAllLeve3CategoryByLeve2Id(Long level2Id);

}
