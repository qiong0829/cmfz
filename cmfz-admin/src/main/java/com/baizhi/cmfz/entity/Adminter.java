package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018/7/4.
 */
public class Adminter {
    private int controllerId;
    private String controllerName;
    private String controllerPassword;
    private String controllerSalt;
    private int controllerStatus;

    public Adminter() {
    }

    public Adminter(int controllerId, String controllerName, String controllerPassword, String controllerSalt, int controllerStatus) {
        this.controllerId = controllerId;
        this.controllerName = controllerName;
        this.controllerPassword = controllerPassword;
        this.controllerSalt = controllerSalt;
        this.controllerStatus = controllerStatus;
    }

    public int getControllerId() {
        return controllerId;
    }

    public void setControllerId(int controllerId) {
        this.controllerId = controllerId;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getControllerPassword() {
        return controllerPassword;
    }

    public void setControllerPassword(String controllerPassword) {
        this.controllerPassword = controllerPassword;
    }

    public String getControllerSalt() {
        return controllerSalt;
    }

    public void setControllerSalt(String controllerSalt) {
        this.controllerSalt = controllerSalt;
    }

    public int getControllerStatus() {
        return controllerStatus;
    }

    public void setControllerStatus(int controllerStatus) {
        this.controllerStatus = controllerStatus;
    }

    @Override
    public String toString() {
        return "Adminter{" +
                "controllerId=" + controllerId +
                ", controllerName='" + controllerName + '\'' +
                ", controllerPassword='" + controllerPassword + '\'' +
                ", controllerSalt='" + controllerSalt + '\'' +
                ", controllerStatus=" + controllerStatus +
                '}';
    }
}
