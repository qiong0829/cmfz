<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript">
            $("#search1").searchbox({
                searcher:function (value,name) {
                    $("#datagrid2").datagrid({
                       url:"${pageContext.request.contextPath}/allFuzzyGuru?name="+name+"&value="+value+"",
                    });
                },
                menu:"#condition",
                prompt:"输入条件",
            });
            $("#datagrid2").datagrid({
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                url:"${pageContext.request.contextPath}/allGurn",
                columns:[[
                    {field:'guruId',title:"上师编号",width:150},
                    {field:'guruName',title:"上师名字",width:150},
                    {field:'guruPicture',title:"上师图片",width:150},
                    {field:'guruBlurb',title:"上师简介",width:150},
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="http://localhost:8080/cmfz-admin/upload/' + rowData.guruPicture + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '</td>' +
                        '</tr></table>';
                },
                pagination:true,
                singleSelect:true,
                pageSize:5,
                pageList:[5,10,15],
                toolbar:"#hander",
            });

    function addgurn() {
        $("#dialog2").dialog({
            title:"新增上师",
            width:300,
            height:200,
            href:"${pageContext.request.contextPath}/main/addguru.jsp",
            buttons:[{
                text:"提交",
                iconCls:"icon-ok",
                handler:function () {
                    $("#form3").form("submit",{
                        url:"${pageContext.request.contextPath}/addGuru",
                        onSubmit:function () {
                            return $("#form3").form("validate");
                        },
                        success:function (msg) {
                            $.messager.show({
                                width:300,
                                height:200,
                                title:"我的消息",
                                msg:msg,
                                timeout:5000,
                            });
                            $("#dialog2").dialog("close");
                            $("#datagrid2").datagrid("reload");
                        }
                    });
                }
            }]
        });
    };
    
    function updateguru() {
        var a=$("#datagrid2").datagrid("getSelected");
        if(a==null){
            $.messager.alert("提示","请选择修改项！");
        }else{
            $("#dialog2").dialog({
                title:"修改轮播图",
                width:300,
                height:200,
                href:"${pageContext.request.contextPath}/main/updaterguru.jsp",
                onLoad:function(){
                    $("#form4").form("load",a);
                },
                buttons:[{
                    text:"保存",
                    iconCls:"icon-save",
                    handler:function () {
                        $("#form4").form("submit",{
                            url:"${pageContext.request.contextPath}/updateGurus",
                            onSubmit:function () {
                                return $("#form4").form("validate");
                            },
                            success:function (msg) {
                                $.messager.show({
                                    width:300,
                                    height:200,
                                    title:"我的消息",
                                    msg:msg,
                                    timeout:5000,
                                });
                                $("#dialog2").dialog("close");
                                $("#datagrid2").datagrid("reload");
                            }
                        });
                    }
                }]
            });
        }
    };

        $("#execal2").linkbutton({
            text:"批量添加",
            iconCls:"icon-add",
            onClick:function () {
                $("#form5").form("submit",{
                    url:"${pageContext.request.contextPath}/batchInsert",
                    onSubmit:function () {
                        return $("#form5").form("validate");
                    },
                    success:function (msg) {
                        $.messager.show({
                            width:300,
                            height:200,
                            title:"我的消息",
                            msg:msg,
                            timeout:2000,
                        });
                        $("#dialog2").dialog("close");
                        $("#datagrid2").datagrid("reload");
                    }
                });
            },
        });

        function uploadguru() {
            location.href="${pageContext.request.contextPath}/uploadGuru"
        }

    </script>

    <table id="datagrid2"></table>
    <div id="hander">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addgurn()">新增上师</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updateguru()">修改上师</a>
        <input id="search1"/>
        <div id="condition">
            <div data-options="name:'all',iconCls:'icon-ok'" >全部</div>
            <div data-options="name:'guruName',iconCls:'icon-ok'" >法名</div>
        </div>
        <div style="float: left">
            <form id="form5" method="post" enctype="multipart/form-data">
                <a id="execal2"></a>
                <input id="execal1" name="execalfile" class="easyui-filebox" data-options="buttonText:'选择文件'"/>
            </form>
        </div>
        <a id="upload" class="easyui-linkbutton" data-options="text:'下载',iconCls:'icon-20130406125519344_easyicon_net_16'" onclick="uploadguru()"></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-help'">帮助</a>
    </div>

    <div id="dialog2"></div>



