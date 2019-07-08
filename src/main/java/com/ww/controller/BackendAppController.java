package com.ww.controller;

import com.github.pagehelper.PageInfo;
import com.ww.pojo.AppCategory;
import com.ww.pojo.AppInfo;
import com.ww.pojo.DataDictionary;
import com.ww.pojo.SelectDTO;
import com.ww.service.AppCategoryService;
import com.ww.service.AppInfoService;
import com.ww.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: wangwei
 * @Description: 用于管理者管理app的controller
 * @Time: 2019/7/8 星期一 11:15
 **/
@Controller
@RequestMapping("backendApp")
public class BackendAppController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private AppCategoryService appCategoryService;

    /**
     * 用于初始化
     * @param model
     * @param pageNum
     */
    @ModelAttribute
    public void init(Model model, Integer pageNum){
        PageInfo pageInfo = new PageInfo();
        if(pageNum == null){
            pageInfo.setPageNum(1); // 默认从第一页开始
        }else {
            pageInfo.setPageNum(pageNum);
        }
        pageInfo.setPageSize(5); // 设置默认页面大小
        model.addAttribute("pageInfo",pageInfo);

        // 查询出所有的平台信息
        List<DataDictionary> flatForms = dataDictionaryService.selectAllFlatform();
        model.addAttribute("flatForms",flatForms);

        // 查询出所有的状态信息
        List<DataDictionary> appStatus = dataDictionaryService.selectAllAppStatus();
        model.addAttribute("appStatus",appStatus);

        // 查询出所有的一级分类
        List<AppCategory> level1Categories = appCategoryService.selectAllLevel1Category();
        model.addAttribute("level1Categories",level1Categories);
    }

    @RequestMapping("/index")
    public String index(Integer pageNum, Model model, @ModelAttribute PageInfo pageInfo){
        // 查出所有app信息，selectDTO各属性值赋空即可
        PageInfo<AppInfo> page = appInfoService.selectPageApps(new SelectDTO(), pageInfo);
        model.addAttribute("pageInfo",page);

        return "app/backendIndex";
    }

    @RequestMapping("/select")
    public String select(SelectDTO selectDTO, Model model, @ModelAttribute("pageInfo") PageInfo pageInfo){
        PageInfo<AppInfo> page = appInfoService.selectPageApps(selectDTO, pageInfo);
        model.addAttribute("pageInfo",page);
        // 用于数据回显
        model.addAttribute("selectDTO",selectDTO);
        return "app/backendIndex";
    }

    /**
     * 跳转到审核页面
     * @param appId
     * @return
     */
    @RequestMapping("/toCheck/{appId}")
    public String toCheck(@PathVariable("appId") Long appId, Model model){
        AppInfo appInfo = appInfoService.selectAppInfoById(appId);
        model.addAttribute("appInfo",appInfo);
        return "app/check";
    }

    /**
     * 根据审核结果更改相关信息
     * @param appId
     * @return
     */
    @RequestMapping("/check/{appId}")
    public String check(@PathVariable("appId") Long appId, Long status){
        int res = appInfoService.updateAppStatusById(status, appId);
        return "forward:/backendApp/index";
    }

}
