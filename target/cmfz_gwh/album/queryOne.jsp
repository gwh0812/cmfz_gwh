<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        var parse=${param.jQuery};
        document.getElementById("queryOne").innerHTML="<img align=\"left\" src=\"${pageContext.request.contextPath}/albumpic/"+parse.thumbnail+"\" Style='margin:10px 10px;width:300px;height:340px'/>"+
            "<p style='text-align:center;margin-top:85px;'>名称："+parse.title+"</p>"+
            "<p style='text-align:center;'>集数："+parse.set_count+"</p>"+
            "<p style='text-align:center;'>发布日期："+parse.create_date+"</p>"+
            "<p style='text-align:center;'>分数："+parse.score+"</p>"+
            "<p style='text-align:center;'>作者："+parse.author+"</p>"+
            "<p style='text-align:center;'>播音："+parse.broadcast+"</p>"+
            "<p style='text-align:center;'>简介："+parse.biref+"</p>";

    })
</script>

<div id="queryOne" style="text-align: center"></div>