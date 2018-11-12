<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<head>
    <script>
    $(function (){
        $("#table").datagrid({
            url: "${pageContext.request.contextPath}/TitlepicController/queryAll",
            autoRowHeight: true,//自适应行高
            fitColumns: true,//让列自适应宽度
            remoteSort: false,
            height: 605,
            toolbar: '#td',//工具栏
            striped: true,//斑马线
            loadMsg: '稍微等等啦，别急~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~',
            rownumbers: true,//显示行号
            columns: [[
                /*----------------------------------------------复选框------------------------------------------------------*/
                {title: "cks", field: "cks", checkbox: true},
                /*------------------------------------------------路径----------------------------------------------------*/
                {title: "thumbnail", field: "thumbnail", width: 100, align: 'center'},
                /*------------------------------------------------描述----------------------------------------------------*/
                {title: "content", field: "content", width: 100, align: 'center'},
                /*-------------------------------------------------状态--------------------------------------------------*/
                {title: "status", field: "status",width:100, align: 'center'},
                /*-------------------------------------------------时间--------------------------------------------------*/
                {title:"date", field: "date",width:100, align: 'center',sortable:true},
                /*-------------------------------------------------删除---------------------------------------------------*/
                {
                    title: 'options', field: 'options', width: 200,
                    formatter: function (value, row, index) {
                        return "<a href='javascript:;' class='options' onclick=\"delRow('" + row.id + "')\" data-options=\"iconCls:'icon-delete',plain:true\"></a>&nbsp;&nbsp;"
                    }
                }
            ]],
            onLoadSuccess:function () {
                $(".options").linkbutton();
            },
            toolbar:'#td',
            view: detailview,
            detailFormatter: function(rowIndex,rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0m"><img src="${pageContext.request.contextPath}/image/' + rowData.thumbnail+ '" style="height:400px;width:600px;margin:10px 0;"></td>' +
                    '<td style="border:0">' +
                    '<p style="color:#666;font-size:18px;">介绍: ' + rowData.content + '</p>' +
                    '<p style="color:#666;font-size:18px;">状态: ' + rowData.status + '</p>' +
                    '<p style="color:#666;font-size:18px;">状态: ' + rowData.date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        });
            /*---------------------------------------------------删除的事件-------------------------------------------------------*/
            //删除一行的事件
            function delRow(id){
                //获取当前的id发送给ajax请求删除id的个人信息

                $.post("${pageContext.request.contextPath}/TitlepicController/delete",{"id":id},function (result) {//响应成功后调回
                    $.messager.show({title:'提示',msg:"删除成功"});
                    //刷新datagrid数据
                    $("#table").datagrid('reload');

                });

            }
            /*----------------------------------------------------增加的事件-------------------------------------------------------------*/
        function openSaveUserDialog() {
            $("#saveUserDialog").dialog({
                buttons:[{
                        iconCls:'icon-add',
                        text:'保存',
                        handler:function () {
                            //保存用户信息

                            $("#addTitlepic").form('submit',{
                                url:'${pageContext.request.contextPath}/TitlepicController/insert',

                                success:function (result) {//响应的格式一定要是json格式字符串  使用的话要先转换为js对象

                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success) {
                                        //提示信息
                                        $.messager.show({title:'提示',msg:"用户添加成功！！"});
                                    }else{
                                        //提示信息
                                        $.messager.show({title:'提示',msg:resultObj.message});
                                    }
                                    $("#saveUserDialog").dialog('close');
                                    //刷新datagrid
                                    $("#table").datagrid('reload');
                                }
                            })
                        }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#saveUserDialog").dialog('close');
                    }
                }]
            })
        }
        /*---------------------------------------------多选删除------------------------------------------------------------------*/
        function delBatchRows(){
            var rows=$("#table").datagrid('getSelections');
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
                    url:"${pageContext.request.contextPath}/TitlepicController/deleteAll",
                    type:"POST",
                    traditional:true,//传递数据类型的数据时必须设置这个属性为true
                    data:{id:ids},
                    success:function (result) {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除成功！！！"});
                        //刷新datagrid
                        $("#table").datagrid('reload');
                    },
                    error:function () {
                        //消息提示
                        $.messager.show({title:'提示',msg:"删除失败！！"});
                        //刷新datagrid
                        $("#table").datagrid('reload');
                    }
                })
            }
        }
    </script>
</head>

<table id="table"></table>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<div id="td">
    <a href="#" class="easyui-linkbutton" onclick="openSaveUserDialog();" data-options="iconCls:'icon-add',">添加</a>
    <a href="#" class="easyui-linkbutton" onclick="delBatchRows();" data-options="iconCls:'icon-delete',">批量删除</a>
</div>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<%--保存用户对话框--%>
<div id="saveUserDialog" data-options="href:'${pageContext.request.contextPath}/titlepic/addTitlepic.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存用户信息'"></div>
<%--更新用户对话框--%>
<div id="editUserDialog" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'"></div>
<%---------------------------------------------------------------------------------------------------------------------------------------%>

