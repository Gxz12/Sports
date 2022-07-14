package com.example.sports.DAO;
import com.example.sports.entity.Course;
import com.example.sports.entity.RunningDataCollection;
import com.example.sports.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    public User selectUserById(long id);

    public User selectUserByName(String name);

    public int insertUser(User user);

    public int insertCourse(Course course);

    public int insertRdc(RunningDataCollection rdc);
}
