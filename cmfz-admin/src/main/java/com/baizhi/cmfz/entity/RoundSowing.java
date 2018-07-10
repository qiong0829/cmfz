package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/6.
 */
@Component
public class RoundSowing implements Serializable{
    private String roundId;
    private String roundPath;
    @JSONField(format = "yyyy-MM-dd")
    private Date roundPushtime;
    private String roundDescribe;
    private String roundStatus;

    public RoundSowing() {
    }

    public RoundSowing(String roundId, String roundPath, Date roundPushtime, String roundDescribe, String roundStatus) {
        this.roundId = roundId;
        this.roundPath = roundPath;
        this.roundPushtime = roundPushtime;
        this.roundDescribe = roundDescribe;
        this.roundStatus = roundStatus;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId;
    }

    public String getRoundPath() {
        return roundPath;
    }

    public void setRoundPath(String roundPath) {
        this.roundPath = roundPath;
    }

    public Date getRoundPushtime() {
        return roundPushtime;
    }

    public void setRoundPushtime(Date roundPushtime) {
        this.roundPushtime = roundPushtime;
    }

    public String getRoundDescribe() {
        return roundDescribe;
    }

    public void setRoundDescribe(String roundDescribe) {
        this.roundDescribe = roundDescribe;
    }

    public String getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(String roundStatus) {
        this.roundStatus = roundStatus;
    }

    @Override
    public String toString() {
        return "RoundSowing{" +
                "roundId=" + roundId +
                ", roundPath='" + roundPath + '\'' +
                ", roundPushtime=" + roundPushtime +
                ", roundDescribe='" + roundDescribe + '\'' +
                ", roundStatus='" + roundStatus + '\'' +
                '}';
    }
}
