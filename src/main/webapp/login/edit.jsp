<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script>

</script>
<div style="text-align: center;">
    <form id="editUserInputForm" class="easyui-form" method="post">
        <div style="margin-top: 70px;">
            用户名: <input type="text" value="${sessionScope.username}" name="username" class="easyui-textbox" data-options="required:true,validType:'uname'">
        </div>
        <div style="margin-top: 20px;">
            旧密码: <input type="password" name="oldPassword"  class="easyui-textbox">
        </div>
       <div style="margin-top: 20px;">
            新密码: <input type="password" name="newPassword"  class="easyui-textbox">
        </div>
    </form>
</div>
