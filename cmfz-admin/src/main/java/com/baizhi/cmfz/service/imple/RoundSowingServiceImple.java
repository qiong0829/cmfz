package com.baizhi.cmfz.service.imple;

import com.baizhi.cmfz.dao.RoundSowingDao;
import com.baizhi.cmfz.entity.RoundSowing;
import com.baizhi.cmfz.service.RoundSowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2018/7/6.
 */
/**
 * @Description 查找所有分类列表
 * @Author      张文琼
 * @Time        2018-07-05 16:33:30

 */
@Service
@Transactional
public class RoundSowingServiceImple implements RoundSowingService{
    @Autowired
    private RoundSowingDao rd;
    @Override
    /**
     * @Description 分页查找所有轮播信息
     * @Author      张文琼
     * @Time        2018-07-05 16:33:30
     * @Param       nowpage当前页 pagesize
     * @Exception
     */
    @Transactional
    public Map<String, Object> queryRSAll(Integer nowPage, Integer pageSize) {
        List<RoundSowing> rs = rd.selectRSAll((nowPage - 1) * pageSize,pageSize);
        int i = rd.selectCount();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",rs);
        return map;
    }
    /**
     * @Description 添加轮播信息
     * @Author      张文琼
     * @Time        2018-07-06 16:33:30
     * @Param       nowpage当前页 pagesize
     * @Exception
     */
    @Transactional
    @Override
    public Integer addRoundSowing(RoundSowing roundSowing) {

        return rd.insertRoundSowing(roundSowing);
    }
    /**
     * @Description 修改轮播信息
     * @Author      张文琼
     * @Time        2018-07-05 16:33:30
     * @Param       nowpage当前页 pagesize
     * @Exception
     */
    @Transactional
    @Override
    public Integer modifyRoundSowing(RoundSowing roundSowing) {
        return rd.updateRoundSowing(roundSowing);
    }


}
