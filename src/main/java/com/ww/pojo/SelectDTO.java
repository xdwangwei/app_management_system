package com.ww.pojo;
/**
 * @Author: wangwei
 * @Description: 封装开发者选择的全部查询条件
 * @Time: 2019/7/5 星期五 11:16
 **/
public class SelectDTO {

    private Long devId;

    private String softwareName;
    private Long appStatusId;
    private Long flatFormId;
    private Long level1Id;
    private Long level2Id;
    private Long level3Id;

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public Long getAppStatusId() {
        return appStatusId;
    }

    public void setAppStatusId(Long appStatusId) {
        this.appStatusId = appStatusId;
    }

    public Long getFlatFormId() {
        return flatFormId;
    }

    public void setFlatFormId(Long flatFormId) {
        this.flatFormId = flatFormId;
    }

    public Long getLevel1Id() {
        return level1Id;
    }

    public void setLevel1Id(Long level1Id) {
        this.level1Id = level1Id;
    }

    public Long getLevel2Id() {
        return level2Id;
    }

    public void setLevel2Id(Long level2Id) {
        this.level2Id = level2Id;
    }

    public Long getLevel3Id() {
        return level3Id;
    }

    public void setLevel3Id(Long level3Id) {
        this.level3Id = level3Id;
    }

    @Override
    public String toString() {
        return "SelectDTO{" +
                "devId=" + devId +
                ", softwareName='" + softwareName + '\'' +
                ", appStatusId=" + appStatusId +
                ", flatFormId=" + flatFormId +
                ", level1Id=" + level1Id +
                ", level2Id=" + level2Id +
                ", level3Id=" + level3Id +
                '}';
    }
}
