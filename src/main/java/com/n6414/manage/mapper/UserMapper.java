package com.n6414.manage.mapper;

import com.n6414.manage.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert("INSERT into admin(trueName,nickName,address,userName,passWord,role) VALUES(#{trueName},#{nickName},#{address},#{userName},#{passWord},'1')")
    int saveUser(@Param("trueName") String truename,@Param("nickName")String nickname,@Param("address")String address,@Param("userName") String userName, @Param("passWord") String passWord);

    @Select("select * from admin where username=#{name}")
    User selectUser(String userName);

    @Select("select * from admin")
    List<User> selectAllUsers();

    @Select("select * from admin where username=#{userName} or truename =#{trueName}")
    List<User> searchUser(String trueName, String userName);
}
