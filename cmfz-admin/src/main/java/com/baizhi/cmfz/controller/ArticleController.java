package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/8.
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService as;



    /**
     * @Description 本地上传下载问价
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       files
     * @Exception
     */
    @RequestMapping("/uploadPictures")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @Description 添加文章信息
     * @Author      张文琼
     * @Time        2018-07-08 13:24:30
     * @Param       articleName articleBlurb articleStatus
     * @Exception
     */
    @RequestMapping("/insertArticles")
    @ResponseBody
    public String addArticles(String articleName,String guruId,String articleBlurb,
    String articleStatus){
        Article article=new Article();
        article.setArticleId(UUID.randomUUID().toString().replace("-",""));
        article.setArticleName(articleName);
        article.setGuruId(guruId);
        article.setArticleBlurb(articleBlurb);
        article.setArticlePushtime(new Date());
        if(articleStatus==null){
            article.setArticleStatus("未上架");
        }else{
            article.setArticleStatus("上架");
        }

        as.addArticle(article);
        return "add success";
    }
}
