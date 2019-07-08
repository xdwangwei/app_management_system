package com.ww.pojo;

import java.util.Date;
import java.util.List;

public class AppCategory {

    private Long id;

    private String categoryCode;

    private String categoryName;

    private Long parentId;

    private Long createdBy;

    private Date creationTime;

    private Long modifyBy;

    private Date modifyDate;

    public List<AppInfo> getAppInfos() {
        return appInfos;
    }

    public void setAppInfos(List<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    private List<AppInfo> appInfos; // 属于此类的多个app

    public AppCategory(Long id, String categoryCode, String categoryName, Long parentId, Long createdBy, Date creationTime, Long modifyBy, Date modifyDate) {
        super();
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.parentId = parentId;
        this.createdBy = createdBy;
        this.creationTime = creationTime;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public AppCategory() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
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
}