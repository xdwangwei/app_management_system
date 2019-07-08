package com.ww.controller;

import com.github.pagehelper.PageInfo;
import com.ww.pojo.*;
import com.ww.service.AppCategoryService;
import com.ww.service.AppInfoService;
import com.ww.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: wangwei
 * @Description: 用于开发者管理app的controller
 * @Time: 2019/7/4 星期四 18:33
 **/
@Controller
@RequestMapping("/devApp")
public class DevAppController {

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

    @RequestMapping("/index/devId/{devId}")
    public String index(@PathVariable("devId") Long devId, Model model, @ModelAttribute("pageInfo") PageInfo pageInfo){

        // 按照分页条件和开发者id查询出一页的app信息列表
        PageInfo<AppInfo> page = appInfoService.selectPageByDevId(devId, pageInfo);
        model.addAttribute("pageInfo", page);

        return "app/devIndex";
    }

    @RequestMapping("/select")
    public String select(SelectDTO selectDTO, Model model, @ModelAttribute("pageInfo") PageInfo pageInfo){
        PageInfo<AppInfo> page = appInfoService.selectPageApps(selectDTO, pageInfo);
        model.addAttribute("pageInfo",page);
        // 用于数据回显
        model.addAttribute("selectDTO",selectDTO);
        return "app/devIndex";
    }

    /**
     * 跳转到新增App信息填写页面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "app/add";
    }

    /**
     * 添加应用信息
     * @return
     */
    @RequestMapping("/add")
    public String add(AppInfo appInfo){
        System.out.println(appInfo);
        int res = appInfoService.insertAppInfo(appInfo);
        return "forward:/devApp/index/devId/"+appInfo.getDevId();
    }

    /**
     * 根据app信息id删除此条记录
     * @return
     */
    @RequestMapping("/deleteApp/{appId}")
    public String deleteApp(@PathVariable("appId") Long appId, HttpSession session){
        int res = appInfoService.deleteAppInfoById(appId);
        Long devId = ((DevUser)session.getAttribute("devUser")).getId();
        return "forward:/devApp/index/devId/"+devId;
    }

    /**
     * 跳转到新增App信息修改页面
     * @return
     */
    @RequestMapping("/toEdit/{appId}")
    public String toEdit(@PathVariable("appId") Long appId, Model model){
        AppInfo appInfo = appInfoService.selectAppInfoById(appId);
        model.addAttribute("appInfo",appInfo);
        return "app/edit";
    }

    /**
     * 更新记录信息
     * @param appInfo
     * @return
     */
    @RequestMapping("/update/{appId}")
    public String updateAppInfo(@PathVariable("appId") Long appId,  AppInfo appInfo){
        appInfo.setId(appId);
        int res = appInfoService.updateAppInfo(appInfo);
        return "forward:/devApp/index/devId/"+appInfo.getDevId();
    }

    @RequestMapping("/detailInfo/{appId}")
    public String detailInfo(@PathVariable("appId") Long appId, Model model){
        AppInfo appInfo = appInfoService.selectAppInfoById(appId);
        model.addAttribute("appInfoDetail",appInfo);
        return "app/detail";
    }
}
