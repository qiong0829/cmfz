package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/7.
 */
@Controller
public class GuruController {
    @Autowired
    private GuruService gs;

    /**
     * @Description 分页查所有的上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       nowpage当前页 pageSi每页的条数
     * @Exception
     */
    @RequestMapping("/allGurn")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer rows){
        return gs.queryAllGuru(page,rows);
    }


    /**
     * @Description 添加上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    @RequestMapping("/addGuru")
    @ResponseBody
    public String insertGuru(String guruName, String guruBlurb, HttpSession session, MultipartFile guruPicture) throws IOException {
        //获得文件夹名
        String realPath = session.getServletContext().getRealPath("upload");

        String replace = realPath.replace("cmfz-admin", "");

        //生成唯一文件名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //截取文件本身的后缀名
        String oldName = guruPicture.getOriginalFilename();
        String substring = oldName.substring(oldName.lastIndexOf("."));
        guruPicture.transferTo(new File(replace+"/"+uuid+substring));

        Guru guru=new Guru();
        guru.setGuruId(uuid);
        guru.setGuruName(guruName);
        guru.setGuruPicture(uuid+substring);
        guru.setGuruBlurb(guruBlurb);
        gs.addGuru(guru);
        return "add success";
    }

    /**
     * @Description 修改上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    @RequestMapping("/updateGurus")
    @ResponseBody
    public String updateGuru(HttpSession session, MultipartFile gurupicture,String guruId,String guruName,String guruBlurb) throws IOException {
        Guru guru=new Guru();
        if("".equals(gurupicture.getOriginalFilename())){
            guru.setGuruPicture("");
        }else{
            //获得文件夹名
            String realPath = session.getServletContext().getRealPath("upload");
            String replace = realPath.replace("cmfz-admin", "");
            //生成唯一文件名
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //截取文件本身的后缀名
            String oldName = gurupicture.getOriginalFilename();
            String substring = oldName.substring(oldName.lastIndexOf("."));
            gurupicture.transferTo(new File(replace+"/"+uuid+substring));
            guru.setGuruPicture(uuid+substring);
        }
        guru.setGuruId(guruId);
        guru.setGuruName(guruName);
        guru.setGuruBlurb(guruBlurb);
        gs.modifyGuru(guru);
        return "update success";


    }

    /**
     * @Description 模糊查询上师信息
     * @Author      张文琼
     * @Time        2018-07-07 13:24:30
     * @Param       guru上师信息
     * @Exception   name列名 value模糊查询的值 nowpage当前页 pageSi每页的条数
     */
    @RequestMapping("/allFuzzyGuru")
    @ResponseBody
    public Map<String,Object> findFuzzyAll(String name,String value,Integer page,Integer rows){
        return gs.queryFuzzyGuru(name,value,page,rows);
    }


    /**
     * @Description 批量插入上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       guru上师信息
     * @Exception
     */
    @RequestMapping("/batchInsert")
    @ResponseBody
    public String batchAddGurn(MultipartFile execalfile, HttpServletRequest request) throws Exception {
        ImportParams params=new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        params.setNeedSave(false);
        List<Guru> gurus = ExcelImportUtil.importExcel(execalfile.getInputStream(), Guru.class, params);
        gs.addBatchGuru(gurus);
        return "BatchAdd success";
    }

    /**
     * @Description 下载上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param
     * @Exception
     */
    @RequestMapping("/uploadGuru")
    public void uploadGurus(HttpServletResponse response) throws IOException {
        List<Guru> gurus = gs.queryAllGurus();
        Workbook workbook= ExcelExportUtil.exportBigExcel(new ExportParams("上师信息","上市表"),Guru.class,gurus);
        ServletOutputStream outputStream = response.getOutputStream();
        String fileName=new String("上师信息.xls".getBytes(),"iso-8859-1");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        workbook.write(outputStream);
        outputStream.close();
    }

    /**
     * @Description 查询所有上师信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param
     * @Exception
     */
    @RequestMapping("/allGurns")
    @ResponseBody
    public List<Guru> allGurnss(){
        return gs.queryAllGurus();
    }
}
