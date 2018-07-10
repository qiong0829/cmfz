package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/7/7.
 */

/**
 * @Description
 * @Author  张文琼
 * @Time    2018-07-04 13:24:30
 */
public interface GuruDao {
    /**
     * @Description 分页查询上师信息
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param       begin开始 end结束
     * @Exception   抛出的异常
     */
    public List<Guru> selectAllGurn(@Param("begin") Integer begin, @Param("end") Integer end);
    /**
     * @Description 查找上师的总条数
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param
     * @Exception   抛出的异常
     */
    public Integer selectGuruCount();
    /**
     * @Description 添加上师
     * @Author      张文我能
     * @Time        2018-07-04 13:24:30
     * @Param       上师信息
     * @Exception   抛出的异常
     */
    public Integer insertGuru(@Param("guru") Guru guru);
    /**
     * @Description 修改上师信息
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param       上师信息
     * @Exception   抛出的异常
     */
    public Integer updateGuru(@Param("guru") Guru guru);
    /**
     * @Description 模糊查询上师并分页
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param       name列名 value模糊查询的值
     * @Exception   抛出的异常
     */
    public List<Guru> selectFuzzyGuru(@Param("name")String name,@Param("value")String value,@Param("begin") Integer begin, @Param("end") Integer end);
    /**
     * @Description 模糊查询总条数
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param       value模糊查询的值
     * @Exception   抛出的异常
     */
    public Integer selectFuzzyCount(@Param("name")String name,@Param("value")String value);
    /**
     * @Description 查询所有上师信息
     * @Author      张文琼
     * @Time        2018-07-04 13:24:30
     * @Param
     * @Exception   抛出的异常
     */
    public List<Guru> selectAllGuru();

}
