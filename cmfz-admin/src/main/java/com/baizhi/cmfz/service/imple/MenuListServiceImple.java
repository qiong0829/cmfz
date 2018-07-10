package com.baizhi.cmfz.service.imple;

import com.baizhi.cmfz.dao.MenuListDao;
import com.baizhi.cmfz.entity.MenuList;
import com.baizhi.cmfz.service.MenuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */
/**
 * @Description
 * @Author  张文琼
 * @Time    2018-07-05 16:33:30
 */
@Service
@Transactional
public class MenuListServiceImple implements MenuListService {
    @Autowired
    private MenuListDao md;

    @Override
    /**
     * @Description 查找所有分类列表
     * @Author      张文琼
     * @Time        2018-07-05 16:33:30
     * @Param
     * @Exception
     */
    public List<MenuList> queryAll() {
        return md.selectAll();
    }
}
