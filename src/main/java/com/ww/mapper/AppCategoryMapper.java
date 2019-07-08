package com.ww.mapper;

import com.ww.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryMapper {

    /**
     * 查询出所有一级分类信息
     * @return
     */
    List<AppCategory> selectAllLevel1Category();

    /**
     * 根据上级分类id查询出所有下级分类信息
     * @param parentId
     * @return
     */
    List<AppCategory> selectChildrenCategoryByParentId(@Param("parentId") Long parentId);
}