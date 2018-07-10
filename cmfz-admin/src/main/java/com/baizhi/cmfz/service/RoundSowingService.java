package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.RoundSowing;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface RoundSowingService {
    /**
     * @Description 分页查询轮播信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       nowpage当前页 pageSi每页的条数
     * @Exception
     */
    public Map<String,Object> queryRSAll(Integer nowPage, Integer pageSize);
    /**
     * @Description 添加轮播图信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       roundSowing轮播图信息
     * @Exception
     */
    public Integer addRoundSowing(RoundSowing roundSowing);
    /**
     * @Description 修改轮播图信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       roundSowing轮播图信息
     * @Exception
     */
    public Integer modifyRoundSowing(RoundSowing roundSowing);
}
