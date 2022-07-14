package com.example.sports.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name ="_user"
        /*uniqueConstraints={
@UniqueConstraint(columnNames = {
    })
}*/)
@RequestMapping("/demoUser")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private int height;

    private int weight;

    private int age;

    private boolean sex; //True-Male False-Female


    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name = "_coursesList",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    private List<Course> coursesList;
    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "_RDC_list",
            joinColumns = @JoinColumn (name = "RDC_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<RunningDataCollection> rdcList;

    public List<RunningDataCollection> getRdcList() {
        return rdcList;
    }

    public void setRdcList(List<RunningDataCollection> rdtList) {
        this.rdcList = rdcList;
    }

    public int getTotalDistance(List<RunningDataCollection> rdcList){
        int re = 0;
        for(RunningDataCollection rdc: rdcList){
            re += rdc.getDistance();
        }
        return re;
    }

    public long getTotalTime(List<RunningDataCollection> rdcList){
        long re = 0;
        for(RunningDataCollection rdc : rdcList){
            re += rdc.getTime();
        }
        return re;
    }

    public double getAvgPacePerHour(){
        double hour = this.getTotalTime(this.getRdcList()) / 3600.0;
        return this.getTotalTime(this.getRdcList())/ hour;
    }
   /* @ManyToMany
    @JsonBackReference
   private List<SignIn> signIns = new ArrayList<SignIn>();*/

    @Column(name = "enabled")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User() {
        super();
        this.enabled = false;
    }

    public User(long id, @NotBlank String username, @NotBlank String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /*public User(SignUpForm form) {
        this.username = form.getUsername();
        this.password = form.getPassword();
        this.height = form.getHeight();
        this.weight = form.getWeight();
        this.age = form.getAge();
        this.sex = form.getSex();
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
