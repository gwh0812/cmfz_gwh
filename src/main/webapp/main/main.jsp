<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
    /*-------------------------------------------------------菜单栏----------------------------------------------------------------*/
    $ (function () {
        //页面加载完成后显示菜单数据
        $.post("${pageContext.request.contextPath}/MenuController/queryAll",function (menu) {
            //通过accordion的添加方法追加菜单
            console.log(menu);
            //遍历一级菜单
            $.each(menu,function (index,m) {
                //遍历二级菜单
                var content = "<div style='text-align:center;'>";
                $.each(m.children,function(idx,child){
                    content += "<a onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" style='width:95%;margin:10px 0px; border: 1px #999999 solid;' class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.name+"</a><br>";
                });
                content += "</div>"
                //添加菜单
                $("#menu").accordion('add',{
                    title:m.name,
                    iconCls:m.iconCls,
                    content:content,
                })

            });
        });
    });

/*---------------------------------------------------管理员密码的修改--------------------------------------------------------------------*/
    function openUserUpdate(){
        $("#UserUpdate").dialog({
            href:'${pageContext.request.contextPath}/login/edit.jsp',
            buttons:[
                {
                    iconCls:'icon-save',
                    text:"修改",

                    handler:function(){
                        $("#editUserInputForm").form('submit',{
                            url:"${pageContext.request.contextPath}/UserController/update",
                            success:function (result) {//注意一定是json字符串  使用需要转为js对象
                                //关闭dialog
                                //alert(result);
                                if(result=="login/login"){
                                    $.messager.show({title:'提示',msg:"用户信息修改成功!!!"});
                                    setTimeout(function(){
                                        location.href="${pageContext.request.contextPath}/login/login.jsp";
                                    },3000);
                                }else{
                                    $.messager.show({title:'提示',msg:"用户信息修改失败!!!"});
                                }
                                $("#UserUpdate").dialog('close');
                                //刷新datagrid
                                $("#table").datagrid('reload');//刷新当前datagrid
                                //提示修改信息
                            }
                        })
                    }
                },
                {
                    iconCls:'icon-cancel',
                    text:"取消",
                    handler:function(){
                        $("#UserUpdate").dialog('close');
                    }
                },
            ]
        });

    }
/*-----------------------------------------------------------------------------------------------------------------------*/

    function addTabs(title,iconCls,href) {
        //添加之前先判断tabs中是否存在这个选项卡
        if (!$("#tt").tabs('exists',title)){
            $("#tt").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:"${pageContext.request.contextPath}/"+href,
            });
        }else{
            $("#tt").tabs('select',title);
        }
    }
    /*-----------------------------------------------------------------------------------------------------------------------*/
</script>

</head>
<body class="easyui-layout">
/*----------------------------------------------------------头部-------------------------------------------------------------*/
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.username}&nbsp;<a  href="javascript:" onclick="openUserUpdate()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/UserController/loginout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>
/*--------------------------------------------------------标题---------------------------------------------------------------*/
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>
/*--------------------------------------------------------菜单---------------------------------------------------------------*/
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>
/*--------------------------------------------------------主页内容---------------------------------------------------------------*/
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
/*---------------------------------------------------------修改窗口--------------------------------------------------------------*/
    <div id="UserUpdate" data-options="draggable:false,iconCls:'icon-edit',width:600,height:400,title:'更新用户信息'"></div>
/*-----------------------------------------------------------------------------------------------------------------------*/

</body> 
</html>