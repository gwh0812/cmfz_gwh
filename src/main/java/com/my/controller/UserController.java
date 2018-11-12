package com.my.controller;

import com.my.entity.User;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserService userService;




    /*登录*/
    @RequestMapping("/login")
    public String login(User user, HttpSession httpSession,String enCode){
        /*调用登录方法查询数据库中是否存在user对象中的数据*/
        User login = userService.login(user);
        /*将在验证码类中存的作用域取出来存在一个对象内*/
        String validationCode = (String) httpSession.getAttribute("validationCode");
        /*判断存起来的验证码和接收到的页面中的验证码是否相同*/
        if (validationCode.equals(enCode)){
            /*判断用登录方法查出来的值是否为空，不为空说明数据库中存在着这个对象就将这个对象中的用户名拿出来，为空就说明数据库中没有这个对象就强制登录*/
            if(login!=null){
                String username = login.getUsername();
                httpSession.setAttribute("username",username);
                return "redirect:/main/main.jsp";
            }

            return "login/login";
        }
        return "login/login";
    }
    /*登出*/
    @RequestMapping("/loginout")
    /*之前在登录的方法里存了一个用户名现在将用户名拿出来，将它的值存成空*/
    public String loginout(HttpSession httpSession){
        httpSession.setAttribute("username",null);
        Object username = httpSession.getAttribute("username");
        System.out.println(username);
        return "login/login";
    }
    /*修改*/
    @RequestMapping("/update")
    public @ResponseBody String update(String username, String oldPassword, String newPassword){
        /*新建一个对象*/
        User user = new User();
        /*将页面传过来的用户名存进去*/
        user.setUsername(username);
        /*在将页面传过来的旧密码存到对象中*/
        user.setPassword(oldPassword);
        /*然后用这个对象调用登录中的查询方法在存到一个用户对象中*/
        User login = userService.login(user);
        /*将查出来的用户对象中的密码拿出来*/
        String password = login.getPassword();
        /*判断这个查出来的这个密码和页面中传过来的新密码是否相等*/
        if (!password.equals(newPassword)){
            /*如果不相等，那新密码和旧密码就不一样，就可以更改密码，将新密码个更改到数据库中*/
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(newPassword);
            userService.update(user1);
            return "login/login";
        }
        /*相反说明新密码和旧密码一样，就不执行修改方法*/
        return "main/main";
    }
}
