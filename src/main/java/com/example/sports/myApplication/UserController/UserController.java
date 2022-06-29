package com.example.sports.myApplication.UserController;

import com.example.sports.myApplication.entity.User;
import com.example.sports.myApplication.UserService.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserController {
  @Resource
  UserService userService;
    //登录：
    @RequestMapping(value="/login")
    public String logIn(){
        System.out.print("the method is logIn");
        return "LogIn";
    }

    @RequestMapping(value="/result")
    public String result(String username, String password){

       // String username = req.getParameter("username");
        // String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean flag = userService.login(user);

        if(flag==true){
            return "Success";
        }else {
            return "Middle";
        }
    }
    @RequestMapping(value="/middle")
    public String middle(){
        return "Login";
    }
    //注册：
    @RequestMapping(value="/signup")
    public String signUp(){
        return "signUp";
    }
    @RequestMapping(value="/end")
    public String end(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = userService.signUp(user);
        if(flag==true){
            return "End1";
        }else{
            return "End2";
        }
    }
}

