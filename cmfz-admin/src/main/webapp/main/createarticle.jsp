<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="../js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.uploadImgServer ="${pageContext.request.contextPath}/uploadPictures";
    editor.customConfig.uploadFileName="files";
    editor.customConfig.onchange=function (html) {
        $("#blurb").val(html);
    };
    editor.create();

    $('#auther').combobox({
        url:"${pageContext.request.contextPath}/allGurns",
        valueField:'guruId',
        textField:'guruName',
    });

    $("#status").switchbutton({
        onText:"上架",
        offText:"未上架",
    });

    $("#savaMessage").linkbutton({
        text:"创建文章",
        iconCls:"icon-save",
        onClick:function () {
            $("#form6").form("submit",{
                url:"${pageContext.request.contextPath}/insertArticles",
                onSubmit:function () {
                    return $("#form6").form("validate");
                },
                success:function (msg) {
                    $.messager.show({
                        width:300,
                        height:200,
                        title:"我的消息",
                        msg:msg,
                        timeout:5000,
                    });
                }
            });
        }
    });

    $("#cancleMessage").linkbutton({
        text:"重置内容",
        iconCls:"icon-cancel",
        onClick:function () {
           $("#form6").form("clear",{});
            editor.txt.clear();
        }
    });


    
</script>
<form id="form6" method="post" style="margin-left: 20px;margin-top: 15px;padding-top: 15px">

    文章标题：<input id="title" class="easyui-textbox" name="articleName"/><br><br>
    文章作者：<input id="auther" name="guruId"><br><br>
    文章状态：<input id="status" name="articleStatus"><br><br>
    文章内容：<br><br>
    <input id="blurb" type="hidden" name="articleBlurb">
    <div id="editor">
        <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
    </div>
    <a id="savaMessage"></a>
    <a id="cancleMessage"></a>
</form>








