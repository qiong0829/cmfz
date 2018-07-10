package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Adminter;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author  张文琼
 * @Time    2018-07-04 13:24:30
 */
public interface AdminterDao {
    /**
     * @Description 通过传递的参数查找管理者
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param       传姓名
     * @Exception   抛出的异常
     */
    public Adminter selectByName(@Param("name") String name);
}
