<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <form id="form2" method="post" enctype="multipart/form-data">
            轮播图描述：<input name="roundId" class="easyui-textbox" data-options="width:170"/><br>
            轮播图描述：<input name="roundDescribe" class="easyui-textbox" data-options="width:170"/><br>
            轮播图状态：<select name="roundStatus" class="easyui-combobox" data-options="width:170,panelHeight:60">
                            <option>展示</option>
                            <option>未展示</option>
                       </select><br>
            上传轮播图：<input name="updatepicture" class="easyui-filebox" data-options="buttonText:'选择文件'">
    </form>



