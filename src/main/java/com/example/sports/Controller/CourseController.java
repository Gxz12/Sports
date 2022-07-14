package com.example.sports.Controller;

import com.example.sports.Service.CourseService;
import com.example.sports.entity.Course;
import com.example.sports.entity.RunningDataCollection;
import com.example.sports.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value="/Course")
public class CourseController {
    @Resource
    private CourseService courseService;


    @RequestMapping(value="/search")
    public String search(){
        return "search";
    }

    @RequestMapping(value = "/result")
    public String result(String courseName, String courseType){

        // String username = req.getParameter("username");
        // String password = req.getParameter("password");

        Course course = new Course();
       course.setCourseName(courseName);
       course.setCourseType(courseType);


        boolean flag = courseService.search(course);

        if(flag){
            return "Success";

        }else {
            return "Fail";
        }
    }

    @RequestMapping(value="/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping(value="/end")
    public String end(HttpServletRequest req, HttpServletResponse resp){

        String courseName = req.getParameter("courseName");
        String courseType = req.getParameter("courseType");

        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseType(courseType);
        boolean flag = courseService.upload(course);
        if(flag==true){
            return "End1";
        }else{
            return "End2";
        }
    }
}
