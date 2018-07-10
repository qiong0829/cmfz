package com.baizhi.cmfz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public class MenuList {
    private int id;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuUrl;
    private int menuLevel;
    private int menuParentId;
    private List<MenuList> lists=new ArrayList<MenuList>();

    public MenuList() {
    }

    public MenuList(int id, String menuName, String menuCode, String menuIcon, String menuUrl, int menuLevel, int menuParentId, List<MenuList> lists) {
        this.id = id;
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.lists = lists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public int getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(int menuParentId) {
        this.menuParentId = menuParentId;
    }

    public List<MenuList> getLists() {
        return lists;
    }

    public void setLists(List<MenuList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "MenuList{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuLevel=" + menuLevel +
                ", menuParentId=" + menuParentId +
                ", lists=" + lists +
                '}';
    }
}
