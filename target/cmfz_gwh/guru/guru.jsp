<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<head>
    <script>
    $(function (){
        $("#guruTable").datagrid({
            url: "${pageContext.request.contextPath}/GuruController/queryAll",
            autoRowHeight: true,//自适应行高
            fitColumns: true,//让列自适应宽度
            remoteSort: false,
            height: 605,
            toolbar: '#gurutd',//工具栏
            striped: true,//斑马线
            loadMsg: '稍微等等啦，别急~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~',
            rownumbers: true,//显示行号
            columns: [[
                /*----------------------------------------------复选框------------------------------------------------------*/
                {title: "复选框", field: "cks", checkbox: true},
                /*------------------------------------------------路径----------------------------------------------------*/
                {title: "路径", field: "headPic", width: 100, align: 'center'},
                /*------------------------------------------------名字----------------------------------------------------*/
                {title: "名字", field: "name", width: 100, align: 'center'},
                /*-------------------------------------------------状态--------------------------------------------------*/
                {title: "状态", field: "staus",width:100, align: 'center'},

                /*-------------------------------------------------删除---------------------------------------------------*/
                {
                    title: 'options', field: 'options', width: 200,
                    formatter: function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"delGuruRow('" + row.id + "')\" data-options=\"iconCls:'icon-delete',plain:true\"></a>&nbsp;&nbsp;"
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#gurutd',
            view: detailview,
            detailFormatter: function(rowIndex,rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0m"><img src="${pageContext.request.contextPath}/img/' + rowData.headPic+ '" style="height:200px;width:200px;margin:10px 0;"></td>' +
                    '<td style="border:0">' +
                    '<p style="color:#666;font-size:18px;">介绍: ' + rowData.name + '</p>' +
                    '<p style="color:#666;font-size:18px;">状态: ' + rowData.staus + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        });
            /*---------------------------------------------------删除的事件-------------------------------------------------------*/
            //删除一行的事件
            function delGuruRow(id){
                //获取当前的id发送给ajax请求删除id的个人信息

                $.post("${pageContext.request.contextPath}/GuruController/delete",{"id":id},function (result) {//响应成功后调回
                    $.messager.show({title:'提示',msg:"删除成功"});
                    //刷新datagrid数据
                    $("#guruTable").datagrid('reload');

                });

            }
            /*----------------------------------------------------增加的事件-------------------------------------------------------------*/
        function openGuruDialog() {
            $("#GuruDialog").dialog({
                buttons:[{
                        iconCls:'icon-add',
                        text:'保存',
                        handler:function () {
                            //保存用户信息

                            $("#addGuru").form('submit',{
                                url:'${pageContext.request.contextPath}/GuruController/insert',

                                success:function (result) {//响应的格式一定要是json格式字符串  使用的话要先转换为js对象

                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success) {
                                        //提示信息
                                        $.messager.show({title:'提示',msg:"用户添加成功！！"});

                                }else{
                                    //提示信息
                                    $.messager.show({title:'提示',msg:resultObj.message});
                        }
                                    //关闭对话框
                                    $("#GuruDialog").dialog('close');
                                    //刷新datagrid
                                    $("#guruTable").datagrid('reload');
                                }
                            })
                        }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#GuruDialog").dialog('close');
                    }
                }]
            })
        }
        /*---------------------------------------------多选删除------------------------------------------------------------------*/
        function Gurudel(){
            var rows=$("#guruTable").datagrid('getSelections');
            if (rows.length<=0){
                $.messager.show({title:'提示',msg:"至少选中一行！！！！"});
            }else{
                 var ids=[];
                 for (var i=0;i<rows.length;i++){
                     console.log(rows[i].id);
                     ids.push(rows[i].id);
                 }
                 console.log(ids);
                 //发送ajax请求传递数组  注意：$get,$post只能传递简单数据（key=value）不能传递数组类型的数据
                //如果想要传递数组类型的数据只能使用 $.ajax并且还要设置其中的一个属性
                $.ajax({
                    url:"${pageContext.request.contextPath}/GuruController/deleteAll",
                    type:"POST",
                    traditional:true,//传递数据类型的数据时必须设置这个属性为true
                    data:{id:ids},
                    success:function (result) {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除成功！！！"});
                        //刷新datagrid
                        $("#guruTable").datagrid('reload');
                    },
                    error:function () {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败！！"});
                        //刷新datagrid
                        $("#guruTable").datagrid('reload');
                    }
                })
            }
        }
    </script>
</head>

<table id="guruTable"></table>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<div id="gurutd">
    <a href="#" class="easyui-linkbutton" onclick="openGuruDialog();" data-options="iconCls:'icon-add',">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="Gurudel();" data-options="iconCls:'icon-delete',">批量删除</a>
</div>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<%--保存用户对话框--%>
<div id="GuruDialog" data-options="href:'${pageContext.request.contextPath}/guru/addGuru.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存信息'"></div>

<%---------------------------------------------------------------------------------------------------------------------------------------%>

