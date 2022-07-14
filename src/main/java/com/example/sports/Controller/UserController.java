package com.example.sports.Controller;

import com.example.sports.Service.UserService;
import com.example.sports.entity.Course;
import com.example.sports.entity.RunningDataCollection;
import com.example.sports.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController // This means that this class is a Controller
@RequestMapping(value="/userDemo") // This means URL's start with /demo (after Application path)

public class UserController {

  @Resource
  UserService userService;
    //登录：
    @RequestMapping(value="/login")
    @ResponseBody
    public String logIn(){
        return "logIn";
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
    @RequestMapping(value="/Middle")
    public String middle(){
        return "login";
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

    @RequestMapping(value = "/getCoursesList")
    public String getCoursesList(){
        return "getCourseList";
    }

    @RequestMapping(value = "/addCourseToList")
    public String addCourseToList(){
        return "addCourseToList";
    }

    @RequestMapping(value = "/AddCourseEnd")
    public String c_end(HttpServletRequest req, HttpServletResponse resp) {

        String courseName = req.getParameter("courseName");
        String courseType = req.getParameter("CourseType");

        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseType((courseType));
        boolean flag = userService.AddCourseToList(course);
        if (flag == true) {
            return "C_End1";
        } else {
            return "C_End2";
        }
    }

    @RequestMapping(value = "/searchRdc")
            public String searchRdc(){
                return "searchRdc";}

    @RequestMapping(value = "/r_result")
        public String r_result(Date date){
        RunningDataCollection rdc= new RunningDataCollection();
        rdc.setDate(date);
        boolean flag = userService.searchRdc(rdc);
        if(flag) return "Success";
        else return "Fail";
    }

    @RequestMapping(value = "/getRdcList")
    public String getRdcList(){
        return "getRdcList";
    }

    @RequestMapping(value = "/addRdcToList")
    public String addRdcToList(){
        return "addRdcToList";
    }

    @RequestMapping(value = "/AddRdcEnd")
    public String r_end(HttpServletRequest req, HttpServletResponse resp) {

        String date = req.getParameter("rdcDate");
        String time = req.getParameter("time");
        String distance = req.getParameter("distance");

        RunningDataCollection rdc=new RunningDataCollection();
        rdc.setDate(date);
        rdc.setTime(time);
        rdc.setDistance(distance);

        boolean flag = userService.AddRdcToList(rdc);
        if (flag == true) {
            return "R_End1";
        } else {
            return "R_End2";
        }
    }

    @RequestMapping(value = "/searchCourse")
    public String searchCourse(){
        return "searchCourse";}

    @RequestMapping(value = "/c_result")
    public String c_result(String courseName){
        Course course = new Course();
        course.setCourseName(courseName);
        boolean flag = userService.searchCourse(course);
        if(flag) return "Success";
        else return "Fail";
    }

}

