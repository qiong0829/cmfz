package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/7.
 */
public interface GuruService {
    /**
     * @Description 分页查所有的上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       nowpage当前页 pageSi每页的条数
     * @Exception
     */
    public Map<String,Object> queryAllGuru(Integer nowpage, Integer pageSize);
    /**
     * @Description 添加上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    public Integer addGuru(Guru guru);
    /**
     * @Description 修改上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    public Integer modifyGuru(Guru guru);
    /**
     * @Description 模糊查询上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception   name列名 value模糊查询的值 nowpage当前页 pageSi每页的条数
     */
    public Map<String,Object> queryFuzzyGuru(String name,String value,Integer nowpage, Integer pageSize);
    /**
     * @Description 批量插入上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    public void addBatchGuru(List<Guru> gurus);
    /**
     * @Description 查询所有上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param
     * @Exception
     */
    public List<Guru> queryAllGurus();
}
