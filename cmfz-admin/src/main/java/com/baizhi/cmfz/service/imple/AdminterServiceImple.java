package com.baizhi.cmfz.service.imple;

import com.baizhi.cmfz.dao.AdminterDao;
import com.baizhi.cmfz.entity.Adminter;
import com.baizhi.cmfz.service.AdminterService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/7/4.
 */
/**
 * @Description
 * @Author  张文琼
 * @Time    2018-07-04 13:33:30
 */
@Service
@Transactional
public class AdminterServiceImple implements AdminterService {

    @Autowired
    private AdminterDao adminterDao;

    @Override
    /**
     * @Description 通过传递的参数登录
     * @Author      张文琼
     * @Time        2018-07-04 13:33:30
     * @Param       传姓名和密码
     * @Exception   抛出的异常
     */
    public Adminter login(String name, String password) {
        Adminter adminter = adminterDao.selectByName(name);
        String pwd=adminter.getControllerPassword();
        String passw=DigestUtils.sha1Hex(password +adminter.getControllerSalt());
        if(pwd.equals(passw)){
            return adminter;
        }else{
            return null;
        }

    }
}
