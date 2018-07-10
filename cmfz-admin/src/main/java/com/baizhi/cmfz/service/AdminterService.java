package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Adminter;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface AdminterService {
    /**
     * @Description 通过用户名密码登录
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param       name管路员姓名  password密码
     * @Exception
     */
    public Adminter login(String name,String password);
}
