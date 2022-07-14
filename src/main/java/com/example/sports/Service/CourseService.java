package com.example.sports.Service;

import com.example.sports.DAO.CourseMapper;
import com.example.sports.DAO.RdcMapper;
import com.example.sports.entity.Course;
import com.example.sports.entity.RunningDataCollection;
import com.example.sports.entity.User;

import javax.annotation.Resource;

public class CourseService {
    @Resource
    private CourseMapper courseMapper;

    public Course selectUserById(long id){
        return courseMapper.selectCourseById(id);
    }

    public boolean upload(Course course){
        int x = courseMapper.insertCourse (course);
        if(x>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean search(Course course){
        String name = course.getCourseName();
        Course course1 =  courseMapper.selectCourseByName(name);
        if(course1==null){
            return false;
        }else{
            return true;
            }
    }
}
