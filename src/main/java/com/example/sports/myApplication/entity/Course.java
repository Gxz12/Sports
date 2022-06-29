package com.example.sports.myApplication.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name ="_course"
        /*uniqueConstraints={
        @UniqueConstraint(columnNames = {
                "courseName"
        })
}*/)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String courseName;

    @NotBlank
    private String courseType;

    public Course(){
        super();
    }

    public Course(long id, String courseName, String courseType){
        this.id = id;
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
