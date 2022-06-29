package com.example.sports.myApplication.UserService;

import com.example.sports.myApplication.entity.User;
import com.example.sports.myApplication.DAO.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
