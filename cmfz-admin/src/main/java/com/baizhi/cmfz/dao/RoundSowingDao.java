package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.RoundSowing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */
public interface RoundSowingDao {
    /**
     * @Description 分页查所有轮播图信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       begin开始 end结束
     * @Exception
     */
    public List<RoundSowing> selectRSAll(@Param("begin") Integer begin, @Param("end") Integer end);
    /**
     * @Description 查到的轮播图的总条数
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param
     * @Exception
     */
    public Integer selectCount();
    /**
     * @Description 添加轮播图信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       roundSowing轮播图信息
     * @Exception
     */
    public Integer insertRoundSowing(@Param("roundSowing") RoundSowing roundSowing);
    /**
     * @Description 修改轮播图信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       roundSowing轮播图信息
     * @Exception
     */
    public Integer updateRoundSowing(@Param("roundSowing") RoundSowing roundSowing);
}
