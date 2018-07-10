package com.baizhi.cmfz.entity;

import java.util.Date;

/**
 * Created by Administrator on 2018/7/9.
 */
public class Log {
    private String logId;
    private String logUser;
    private Date logDatetime;
    private String logSourceStyle;
    private String logAction;
    private String logDetails;
    private String logResult;

    public Log() {
    }

    public Log(String logId, String logUser, Date logDatetime, String logSourceStyle, String logAction, String logDetails, String logResult) {
        this.logId = logId;
        this.logUser = logUser;
        this.logDatetime = logDatetime;
        this.logSourceStyle = logSourceStyle;
        this.logAction = logAction;
        this.logDetails = logDetails;
        this.logResult = logResult;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Date getLogDatetime() {
        return logDatetime;
    }

    public void setLogDatetime(Date logDatetime) {
        this.logDatetime = logDatetime;
    }

    public String getLogSourceStyle() {
        return logSourceStyle;
    }

    public void setLogSourceStyle(String logSourceStyle) {
        this.logSourceStyle = logSourceStyle;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logDatetime=" + logDatetime +
                ", logSourceStyle='" + logSourceStyle + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logDetails='" + logDetails + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}
