package com.baizhi.cmfz.service.imple;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/7.
 */
@Service
public class GuruServiceImple implements GuruService{
    @Autowired
    private GuruDao gd;


    /**
     * @Description 分页查所有的上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       nowpage当前页 pageSi每页的条数
     * @Exception
     */
    @Override
    @Transactional
    public Map<String,Object> queryAllGuru(Integer nowpage, Integer pageSize) {
        List<Guru> gurus = gd.selectAllGurn((nowpage - 1) * pageSize, pageSize);
        Integer integer = gd.selectGuruCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",integer);
        map.put("rows",gurus);
        return map;
    }


    /**
     * @Description 添加上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    @Override
    @Transactional
    public Integer addGuru(Guru guru) {
        return gd.insertGuru(guru);
    }


    /**
     * @Description 修改上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    @Override
    @Transactional
    public Integer modifyGuru(Guru guru) {
        return gd.updateGuru(guru);
    }


    /**
     * @Description 模糊查询上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception   name列名 value模糊查询的值 nowpage当前页 pageSi每页的条数
     */
    @Override
    @Transactional
    public Map<String, Object> queryFuzzyGuru(String name, String value, Integer nowpage, Integer pageSize) {
        List<Guru> gurus = gd.selectFuzzyGuru(name,value,(nowpage - 1) * pageSize, pageSize);
        Integer integer = gd.selectFuzzyCount(name,value);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",integer);
        map.put("rows",gurus);
        return map;
    }

    /**
     * @Description 批量插入上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    @Override
    @Transactional
    public void addBatchGuru(List<Guru> gurus) {
       for (int i=0;i<gurus.size();i++){
           gd.insertGuru(gurus.get(i));
       }
    }


    /**
     * @Description 查询所有上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param
     * @Exception
     */
    @Override
    @Transactional
    public List<Guru> queryAllGurus() {
        return gd.selectAllGuru();
    }
}
