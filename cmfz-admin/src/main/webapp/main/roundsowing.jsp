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

            $("#datagrid1").datagrid({
                remoteSort:false,
                singleSelect:true,
                nowrap:false,
                fitColumns:true,
                url:"${pageContext.request.contextPath}/allRSowing",
                columns:[[
                    {field:'roundId',title:"标识编号",width:150},
                    {field:'roundPath',title:"文件名",width:150},
                    {field:'roundPushtime',title:"创建时间",width:150},
                    {field:'roundDescribe',title:"描述",width:150},
                    {field:'roundStatus',title:"状态",width:150},
                ]],
                view: detailview,
                detailFormatter: function(rowIndex, rowData){
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="http://localhost:8080/cmfz-admin/upload/' + rowData.roundPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '</td>' +
                        '</tr></table>';
                },
                pagination:true,
                singleSelect:true,
                pageSize:5,
                pageList:[5,10,15],
                toolbar:"#hander1",
            });


        function addPicture() {
            $("#dialog1").dialog({
                title:"新增轮播图",
                width:300,
                height:200,
                href:"${pageContext.request.contextPath}/main/addroundsowing.jsp",
                buttons:[{
                    text:"提交",
                    iconCls:"icon-ok",
                    handler:function () {
                        $("#form1").form("submit",{
                            url:"${pageContext.request.contextPath}/addRSowing",
                            onSubmit:function () {
                                return $("#form1").form("validate");
                            },
                            success:function (msg) {
                                $.messager.show({
                                    width:300,
                                    height:200,
                                    title:"我的消息",
                                    msg:msg,
                                    timeout:5000,
                                });
                            $("#dialog1").dialog("close");
                            $("#datagrid1").datagrid("reload");
                            }
                        });
                    }
                }]
            });
        };
        
        function updatePicture() {
            var slect=$("#datagrid1").datagrid("getSelected");
            if(slect==null){
                $.messager.alert("提示","请选择修改项！");
            }else{
                $("#dialog1").dialog({
                    title:"修改轮播图",
                    width:300,
                    height:200,
                    href:"${pageContext.request.contextPath}/main/updateroundsowing.jsp",
                    onLoad:function(){
                        $("#form2").form("load",slect);
                    },
                    buttons:[{
                        text:"保存",
                        iconCls:"icon-save",
                        handler:function () {
                            $("#form2").form("submit",{
                                url:"${pageContext.request.contextPath}/updateRSowing",
                                onSubmit:function () {
                                    return $("#form2").form("validate");
                                },
                                success:function (msg) {
                                    $.messager.show({
                                        width:300,
                                        height:200,
                                        title:"我的消息",
                                        msg:msg,
                                        timeout:5000,
                                    });
                                    $("#dialog1").dialog("close");
                                    $("#datagrid1").datagrid("reload");
                                }
                            });
                        }
                    }]
                });
            }

        }

    </script>

    <table id="datagrid1"></table>
    <div id="hander1">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addPicture()">新增轮播图</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="updatePicture()">修改</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-help'">帮助</a>
    </div>

    <div id="dialog1"></div>



