package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.RoundSowing;
import com.baizhi.cmfz.service.RoundSowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/6.
 */
@Controller
public class RoundSowingController {
    @Autowired
    private RoundSowingService rs;

    @RequestMapping("/allRSowing")
    @ResponseBody
    /**
     * @Description 修改轮播信息
     * @Author      张文琼
     * @Time        2018-07-05 16:33:30
     * @Param       page当前页  rows每页的条数
     * @Exception
     */
    public Map<String,Object> allRoundSowing(Integer page, Integer rows){

        return rs.queryRSAll(page, rows);
    }

    @RequestMapping("/addRSowing")
    @ResponseBody
    /**
     * @Description 添加轮播信息
     * @Author      张文琼
     * @Time        2018-07-05 16:33:30
     * @Param       session roundPath文件名 roundDescribe文件描述 roundStatus文件状态
     * @Exception
     */
    public String addRoundSowing(HttpSession session, MultipartFile roundPath,String roundDescribe,String roundStatus) throws IOException {
        System.out.println(roundDescribe+"==========="+roundStatus);
        //获得文件夹名
        String realPath = session.getServletContext().getRealPath("upload");
        System.out.println("========="+realPath);
        String replace = realPath.replace("cmfz-admin", "");
        System.out.println("==============="+replace);
        //生成唯一文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //截取文件本身的后缀名
        String oldName = roundPath.getOriginalFilename();
        String substring = oldName.substring(oldName.lastIndexOf("."));
        roundPath.transferTo(new File(replace+"/"+uuid+substring));

        RoundSowing roundSowing1=new RoundSowing();
        roundSowing1.setRoundId(uuid);
        roundSowing1.setRoundPath(uuid+substring);
        roundSowing1.setRoundPushtime(new Date());
        roundSowing1.setRoundDescribe(roundDescribe);
        roundSowing1.setRoundStatus(roundStatus);
        rs.addRoundSowing(roundSowing1);
        return "add success";
    }

    /**
     * @Description 修改轮播图信息
     * @Author      张文琼
     * @Time        2018-07-06 13:24:30
     * @Param       roundPath文件名 roundDescribe文件描述 roundStatus文件状态
     * @Exception
     */
    @RequestMapping("/updateRSowing")
    @ResponseBody
    public String updateRoundSowing(HttpSession session, MultipartFile updatepicture,String roundId,String roundDescribe,String roundStatus) throws IOException {

        RoundSowing roundSowing=new RoundSowing();
        if("".equals(updatepicture.getOriginalFilename())){
            roundSowing.setRoundPath("");
        }else{
            //获得文件夹名
            String realPath = session.getServletContext().getRealPath("upload");
            String replace = realPath.replace("cmfz-admin", "");
            //生成唯一文件名
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //截取文件本身的后缀名
            String oldName = updatepicture.getOriginalFilename();
            String substring = oldName.substring(oldName.lastIndexOf("."));
            updatepicture.transferTo(new File(replace+"/"+uuid+substring));
            roundSowing.setRoundPath(uuid+substring);
        }
        roundSowing.setRoundId(roundId);
        roundSowing.setRoundDescribe(roundDescribe);
        roundSowing.setRoundStatus(roundStatus);
        rs.modifyRoundSowing(roundSowing);
        return "update success";
    }

}
