package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * Created by Administrator on 2018/7/7.
 */

public class Guru {
    @Excel(name="上师id",needMerge = true)
    private String guruId;
    @Excel(name="上师名字",needMerge = true)
    private String guruName;
    @Excel(name="上师头像",needMerge = true)
    private String guruPicture;
    @Excel(name="上师简介",needMerge = true)
    private String guruBlurb;

    public Guru() {
    }

    public Guru(String guruId, String guruName, String guruPicture, String guruBlurb) {
        this.guruId = guruId;
        this.guruName = guruName;
        this.guruPicture = guruPicture;
        this.guruBlurb = guruBlurb;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPicture() {
        return guruPicture;
    }

    public void setGuruPicture(String guruPicture) {
        this.guruPicture = guruPicture;
    }

    public String getGuruBlurb() {
        return guruBlurb;
    }

    public void setGuruBlurb(String guruBlurb) {
        this.guruBlurb = guruBlurb;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPicture='" + guruPicture + '\'' +
                ", guruBlurb='" + guruBlurb + '\'' +
                '}';
    }
}
