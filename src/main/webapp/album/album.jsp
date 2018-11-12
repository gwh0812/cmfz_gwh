<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<head>
    <script type="text/javascript">
        $(function(){



            $('#albumtable').treegrid({
                url:'${pageContext.request.contextPath}/AlbumController/queryAll',
                idField:'id',
                treeField:'title',
                autoRowHeight: true,//自适应行高
                fit:true,
                fitColumns: true,//让列自适应宽度
                //remoteSort: false,
                height: 605,
                toolbar: '#albumtd',//工具栏
                striped: true,//斑马线
                animate:"boolean",
                loadMsg: '稍微等等啦，别急~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~',
                columns:[[
                    {field:'title',title:'名字',width:180},
                    {field:'download_url',title:'路径',width:60,align:'right'},
                    {field:'memory',title:'内存',width:80},
                    {field:'duration',title:'时长',width:80},
                ]],
            });


        });

        /*----------------------------------------------------增加的事件-------------------------------------------------------------*/
        function openalbumDialog() {
            $("#albumDialog").dialog({
                width:500,
                height:700,
                buttons:[{
                    iconCls:'icon-add',
                    text:'保存',
                    handler:function () {
                        //保存用户信息

                        $("#addalbum").form('submit',{
                            url:'${pageContext.request.contextPath}/AlbumController/insert',

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
                                $("#albumDialog").dialog('close');
                                //刷新treegrid
                                $('#albumtable').treegrid('reload');
                            }
                        })
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#albumDialog").dialog('close');
                    }
                }]
            })
        }
        /*----------------------------------------------------增加章节的事件-------------------------------------------------------------*/
        function openaddchapter() {
            $("#addchapter").dialog({
                width:500,
                height:400,
                buttons:[{
                    iconCls:'icon-add',
                    text:'保存',
                    handler:function () {
                        //保存用户信息

                        $("#addChapter").form('submit',{
                            url:'${pageContext.request.contextPath}/ChapterController/insert',

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
                                $("#addchapter").dialog('close');
                                //刷新treegrid

                                $('#albumtable').treegrid('reload');
                            }
                        })
                    }
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:function () {
                        $("#addchapter").dialog('close');
                    }
                }]
            })
        }
        /*-------------------------------------------------专辑详情------------------------------------------------*/
        function onenqueryOne() {
            var jQuery=$("#albumtable").treegrid('getSelected');
            var s=JSON.stringify(jQuery);
            /*var id=jQuery.id;*/
            if(jQuery==null){
                $.messager.show({title:'tishi',msg:'请选择一个专辑！！！！！！'});
            }else{
                $("#queryOne").dialog({
                    href:'${pageContext.request.contextPath}/album/queryOne.jsp?jQuery='+s,
                });
            }
        }
        /*-------------------------------------------------下载-----------------------------------------------------------*/
        function upload() {
            var jQuery = $("#albumtable").treegrid('getSelected');
            var downPath = jQuery.download_url;
            alert(downPath);
            location.href="${pageContext.request.contextPath}/ChapterController/download?fileName="+downPath+"&openStyle=attachment";
        }

    </script>
</head>
<table id="albumtable" style="width:600px;height:400px"></table>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<div id="albumtd">
    <a href="#" class="easyui-linkbutton" onclick="openalbumDialog()" data-options="iconCls:'icon-add',">添加专辑</a>
    <a href="#" class="easyui-linkbutton" onclick="openaddchapter()" data-options="iconCls:'icon-add',">添加章节</a>
    <a href="#" class="easyui-linkbutton" onclick="onenqueryOne()" data-options="iconCls:'icon-book',">专辑详情</a>
    <a href="#" class="easyui-linkbutton" onclick="upload()" data-options="iconCls:'icon-edit',">下载章节</a>
</div>
<%---------------------------------------------------------------------------------------------------------------------------------------%>
<%--保存对话框--%>
<div id="albumDialog" data-options="href:'${pageContext.request.contextPath}/album/addalbum.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存信息'"></div>
<div id="addchapter" data-options="href:'${pageContext.request.contextPath}/album/Chapter.jsp',draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存信息'"></div>
<div id="queryOne" data-options="draggable:false,iconCls:'icon-save',width:600,height:400,title:'保存信息'"></div>

<%---------------------------------------------------------------------------------------------------------------------------------------%>


