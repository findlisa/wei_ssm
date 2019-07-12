package com.wei.dao;

import com.wei.domain.role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("SELECT * FROM ROLE WHERE ID IN(SELECT ROLEID FROM USERS_ROLE WHERE USERID=#{id})")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",many=@Many(select = "com.wei.dao.IPermissionDao.findPermissionById"))
    })
    List<role> findRoleByUserId(String id);


    @Select("select * from role")
    List<role> findAll();

    @Insert("insert into role(roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(role role);
}
