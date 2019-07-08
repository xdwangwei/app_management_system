package com.ww.pojo;

import java.util.Date;

public class BackendUser {
    private Long id;

    private String backendCode;

    private String backendName;

    private Long backendType;

    private String backendPassword;

    private Long createdBy;

    private Date creationDate;

    private Long modifyBy;

    private Date modifyDate;


    public BackendUser() {
        super();
    }

    public BackendUser(Long id, String backendCode, String backendName, Long backendType, String backendPassword, Long createdBy, Date creationDate, Long modifyBy, Date modifyDate) {
        this.id = id;
        this.backendCode = backendCode;
        this.backendName = backendName;
        this.backendType = backendType;
        this.backendPassword = backendPassword;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBackendCode() {
        return backendCode;
    }

    public void setBackendCode(String backendCode) {
        this.backendCode = backendCode;
    }

    public String getBackendName() {
        return backendName;
    }

    public void setBackendName(String backendName) {
        this.backendName = backendName;
    }

    public Long getBackendType() {
        return backendType;
    }

    public void setBackendType(Long backendType) {
        this.backendType = backendType;
    }

    public String getBackendPassword() {
        return backendPassword;
    }

    public void setBackendPassword(String backendPassword) {
        this.backendPassword = backendPassword;
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
}