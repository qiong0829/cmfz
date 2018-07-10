package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/7/10.
 */
public interface LogDao {

    public Integer insertLog(@Param("log") Log log);
}
