package com.example.sports.Service;
import com.example.sports.entity.Course;
import com.example.sports.entity.RunningDataCollection;
import com.example.sports.entity.User;
import com.example.sports.DAO.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User selectUserById(long id){
        return userMapper.selectUserById(id);
    }

    public boolean login(User user){
        String name = user.getUsername();
        String password = user.getPassword();
        User u1 =  userMapper.selectUserByName(name);
        if(u1==null){
            return false;
        }else{
            if(u1.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean signUp(User user){
        int x = userMapper.insertUser(user);
        if(x>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean AddCourseToList(Course course){
        int x = userMapper.insertCourse(course);
        if(x>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean searchCourse(Course course){
        String courseName = course.getCourseName();
        User u1 = new User();
        for(Course c: u1.getCoursesList()){
            if(c.getCourseName().equals(courseName)) return true;
        }
        return false;
    }

    public boolean AddRdcToList(RunningDataCollection rdc){
        int x = userMapper.insertRdc(rdc);
        if(x>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean searchRdc(RunningDataCollection rdc){
       Date date =rdc.getDate();
        User u1 = new User();
        for(RunningDataCollection rdc1: u1.getRdcList()){
            if(rdc1.getDate().equals(date)) return true;
        }
        return false;
    }
}
