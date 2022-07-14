package com.example.sports.DAO;

import com.example.sports.entity.Course;


public interface CourseMapper {
    public Course selectCourseById(long id);

    public Course selectCourseByName(String courseName);

    public int insertCourse(Course course);
}
