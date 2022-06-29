package com.example.sports.myApplication.DAO;
import com.example.sports.myApplication.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    public User selectUserById(long id);

    public User selectUserByName(String name);

    public int insertUser(User user);
}
