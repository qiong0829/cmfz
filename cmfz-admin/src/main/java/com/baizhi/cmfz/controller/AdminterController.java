package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.UserMap;
import com.baizhi.cmfz.service.AdminterService;
import com.baizhi.cmfz.util.NewValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
@Controller

public class AdminterController {

   @Autowired
    private AdminterService as;
    @RequestMapping("/login")
    /**
     * @Description 通过传递的参数登录
     * @Author      张文琼
     * @Time        2018-07-04 13:33:30
     * @Param       controllerName管理者姓名 controllerPassword密码
     *              encode验证码 rember response
     * @Exception   抛出的异常
     */
    public String adminterLogin(String controllerName,String controllerPassword,String enCode,HttpSession session,boolean rember,HttpServletResponse response) throws UnsupportedEncodingException {
      String code= (String) session.getAttribute("code");
      if(enCode.equals(code)){
          if(rember){
              String s= URLEncoder.encode(controllerName,"UTF-8");
              Cookie cookie=new Cookie("username",s);
              cookie.setMaxAge(10000);
              cookie.setPath("/");
              response.addCookie(cookie);
              if(as.login(controllerName, controllerPassword)!=null){
                  return "redirect:main/main.jsp";
              }else{
                  return  "redirect:login.jsp";
              }
          }else{
              return  "redirect:login.jsp";
          }

      }else{
          return  "redirect:login.jsp";
      }


    }
    @RequestMapping("/codes")
    /**
     * @Description 验证码
     * @Author      张文琼
     * @Time        2018-07-04 13:33:30
     * @Param
     * @Exception   抛出的异常
     */
    public void getCode(HttpSession session, HttpServletResponse response) throws Exception{
        NewValidateCodeUtils vCode=new NewValidateCodeUtils(100, 30, 4, 10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());

    }


    @RequestMapping("/userMap")
    @ResponseBody
    /**
     * @Description 人数统计分布
     * @Author      张文琼
     * @Time        2018-07-04 13:33:30
     * @Param
     * @Exception   抛出的异常
     */
    public List<UserMap> userMap(){
        long round = Math.round(Math.random() * 1000);
        List<UserMap> us=new ArrayList<UserMap>();
        us.add(new UserMap("北京",round));
        us.add(new UserMap("天津",round));
        us.add(new UserMap("上海",round));
        us.add(new UserMap("重庆",round));
        us.add(new UserMap("河北",round));
        us.add(new UserMap("河南",round));
        us.add(new UserMap("云南",round));
        us.add(new UserMap("辽宁",round));
        us.add(new UserMap("黑龙江",round));
        us.add(new UserMap("湖南",round));
        us.add(new UserMap("安徽",round));
        us.add(new UserMap("山东",round));
        us.add(new UserMap("新疆",round));
        us.add(new UserMap("江苏",round));
        us.add(new UserMap("浙江",round));
        us.add(new UserMap("江西",round));
        us.add(new UserMap("湖北",round));
        us.add(new UserMap("广西",round));
        us.add(new UserMap("甘肃",round));
        us.add(new UserMap("山西",round));
        us.add(new UserMap("内蒙古",round));
        us.add(new UserMap("陕西",round));
        us.add(new UserMap("吉林",round));
        us.add(new UserMap("福建",round));
        us.add(new UserMap("贵州",round));
        us.add(new UserMap("广东",round));
        us.add(new UserMap("青海",round));
        us.add(new UserMap("西藏",round));
        us.add(new UserMap("四川",round));
        us.add(new UserMap("宁夏",round));
        us.add(new UserMap("海南",round));
        us.add(new UserMap("台湾",round));
        us.add(new UserMap("香港",round));
        us.add(new UserMap("澳门",round));
        return us;
    }



}
