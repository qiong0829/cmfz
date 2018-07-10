package com.baizhi.cmfz.service.imple;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/7/10.
 */
@Service
public class LogServiceImple implements LogService {
    @Autowired
    private LogDao ld;
    @Override
    @Transactional
    public void addLog(Log log) {
        ld.insertLog(log);
    }
}
