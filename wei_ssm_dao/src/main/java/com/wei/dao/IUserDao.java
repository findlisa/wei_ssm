package com.wei.dao;

import com.wei.domain.role;
import com.wei.domain.userInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    //查询用户信息，用于传递用户名登录
    @Select("select*from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.wei.dao.IRoleDao.findRoleByUserId")) })
    userInfo findByUserName(String username);

    //查询所有用户信息
    @Select("select * from users")
    List<userInfo> findAll();

    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) " +
            "values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(userInfo userInfo);

    //通过id查询用户信息
    @Select("select*from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.wei.dao.IRoleDao.findRoleByUserId")) })
    userInfo findById(String id);

    //通过用户id查询可添加的角色
    @Select("select * from role where id not in (select roleId from users_role where userId=#{id})")
    List<role> findOtherRoles(String id);

    //给用户添加角色
    @Insert("insert into users_role (roleId,userId) values(#{id},#{userId})")
    void addRoleToUser(@Param("userId") String userId, @Param("id") String id);
}
