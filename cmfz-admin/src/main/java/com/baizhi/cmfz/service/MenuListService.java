package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.MenuList;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface MenuListService {
    /**
     * @Description 查所有分类信息
     * @Author      张文琼
     * @Time        2018-07-05 13:24:30
     * @Param
     * @Exception
     */
    public List<MenuList> queryAll();

}
