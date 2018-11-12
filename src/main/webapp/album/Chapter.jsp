<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $('#cc').combobox({
        url:'${pageContext.request.contextPath}/AlbumController/queryAll',
        valueField:'id',
        textField:'title'
    });
</script>
<head>
    <form action="" id="addChapter" class="easyui-form" method="post" enctype="multipart/form-data" style="text-align: center;margin-top: 100px;line-height: 50px;">
        文件路径:<input name="addalbumtxt" class="easyui-filebox" style="height:25px;width:200px;"/>
        <br>
        名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<input name="title" type="text" class="easyui-textbox" style="height:25px;width:200px;"/>
        <br>
        指定专辑:<input id="cc" name="album_id" style="height:25px;width:200px;">
    </form>
</head>

