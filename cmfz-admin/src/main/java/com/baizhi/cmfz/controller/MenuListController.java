package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.MenuList;
import com.baizhi.cmfz.service.MenuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
@Controller

public class MenuListController {
    @Autowired
    private MenuListService ms;

    /**
     * @Description 查所有分类信息
     * @Author      张文琼
     * @Time        2018-07-05 13:24:30
     * @Param
     * @Exception
     */
    @RequestMapping("/allList")
    @ResponseBody
    public List<MenuList> findAll(){
        return ms.queryAll();
    }
}
