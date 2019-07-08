package com.ww.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AppInfo {

    private Long id;

    private String softwareName;

    private String apkName;

    private String supportRom;

    private String interfaceLanguage;

    private BigDecimal softwareSize;

    private Date updateDate;

    private Long devId;

    private DevUser devUser; //开发者信息 封装对象信息

    private String appInfo; // 介绍

    // private Long status;
    private DataDictionary appStatus; // 封装对象信息

    // private Long flatformId;
    private DataDictionary flatForm; // 封装对象信息

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onSaledate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date offSaledate;

    private Long downloads;

    private Long createdBy;

    private DevUser createdUser; // 封装对象信息

    private Date creationDate;

    private Long modifyBy;

    private DevUser modifyUser; // 封装对象信息

    private Date modifyDate;

    //app分三等级：实用工具>>休闲娱乐>>电子游戏
    // private Long categoryLevel1;//种类一对应的category表中的id
    //
    // private Long categoryLevel2;//种类二对应的category表中的id
    //
    // private Long categoryLevel3;//种类三对应的category表中的id

    // 面向对象设计
    private AppCategory categoryLevel1;
    private AppCategory categoryLevel2;
    private AppCategory categoryLevel3;

    private String logoPicpath;

    private String logoLocpath;

    private Long versionId; // 最近的版本对应的id

    private AppVersion latestVersion;

    private List<AppVersion> appVersions; // 多个版本

    public AppVersion getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(AppVersion latestVersion) {
        this.latestVersion = latestVersion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getSupportRom() {
        return supportRom;
    }

    public void setSupportRom(String supportRom) {
        this.supportRom = supportRom;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Date getOnSaledate() {
        return onSaledate;
    }

    public void setOnSaledate(Date onSaledate) {
        this.onSaledate = onSaledate;
    }

    public Date getOffSaledate() {
        return offSaledate;
    }

    public DataDictionary getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(DataDictionary appStatus) {
        this.appStatus = appStatus;
    }

    public DataDictionary getFlatForm() {
        return flatForm;
    }

    public void setFlatForm(DataDictionary flatForm) {
        this.flatForm = flatForm;
    }

    public void setOffSaledate(Date offSaledate) {
        this.offSaledate = offSaledate;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public AppCategory getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(AppCategory categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public AppCategory getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(AppCategory categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public AppCategory getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(AppCategory categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public DevUser getDevUser() {
        return devUser;
    }

    public void setDevUser(DevUser devUser) {
        this.devUser = devUser;
    }

    public List<AppVersion> getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(List<AppVersion> appVersions) {
        this.appVersions = appVersions;
    }

    public String getLogoPicpath() {
        return logoPicpath;
    }

    public void setLogoPicpath(String logoPicpath) {
        this.logoPicpath = logoPicpath;
    }

    public String getLogoLocpath() {
        return logoLocpath;
    }

    public void setLogoLocpath(String logoLocpath) {
        this.logoLocpath = logoLocpath;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public DevUser getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(DevUser createdUser) {
        this.createdUser = createdUser;
    }

    public DevUser getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(DevUser modifyUser) {
        this.modifyUser = modifyUser;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", softwareName='" + softwareName + '\'' +
                ", apkName='" + apkName + '\'' +
                ", supportRom='" + supportRom + '\'' +
                ", interfaceLanguage='" + interfaceLanguage + '\'' +
                ", softwareSize=" + softwareSize +
                ", updateDate=" + updateDate +
                ", devId=" + devId +
                ", devUser=" + devUser +
                ", appInfo='" + appInfo + '\'' +
                ", appStatus=" + appStatus +
                ", flatForm=" + flatForm +
                ", onSaledate=" + onSaledate +
                ", offSaledate=" + offSaledate +
                ", downloads=" + downloads +
                ", createdBy=" + createdBy +
                ", createdUser=" + createdUser +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyUser=" + modifyUser +
                ", modifyDate=" + modifyDate +
                ", categoryLevel1=" + categoryLevel1 +
                ", categoryLevel2=" + categoryLevel2 +
                ", categoryLevel3=" + categoryLevel3 +
                ", logoPicpath='" + logoPicpath + '\'' +
                ", logoLocpath='" + logoLocpath + '\'' +
                ", versionId=" + versionId +
                ", latestVersion=" + latestVersion +
                ", appVersions=" + appVersions +
                '}';
    }
}