package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.MenuList;


import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
public interface MenuListDao {
    /**
     * @Description 查所有的列表信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param
     * @Exception
     */
    public List<MenuList> selectAll();

}
