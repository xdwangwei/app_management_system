package com.ww.controller;

import com.ww.pojo.AppCategory;
import com.ww.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: wangwei
 * @Description:
 * @Time: 2019/7/5 星期五 10:21
 **/
@Controller
@RequestMapping("/category")
public class AppCategoryController {

    @Autowired
    private AppCategoryService appCategoryService;

    /**
     * 将查询到的信息列表以json字符串格式写回
     * @param level1Id
     * @return
     */
    @RequestMapping("/selectLevel2ByLevel1Id/{level1Id}")
    @ResponseBody
    public List<AppCategory> selectLevel2ByLevel1Id(@PathVariable("level1Id") Long level1Id){
        return appCategoryService.selectAllLeve2CategoryByLevelId(level1Id);
    }

    @RequestMapping("/selectLevel3ByLevel2Id/{level2Id}")
    @ResponseBody
    public List<AppCategory> selectLevel3ByLevel2Id(@PathVariable("level2Id") Long level2Id){
        return appCategoryService.selectAllLeve3CategoryByLeve2Id(level2Id);
    }
}
