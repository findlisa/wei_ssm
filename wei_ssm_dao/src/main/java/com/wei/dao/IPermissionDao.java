package com.wei.dao;

import com.wei.domain.permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<permission>findPermissionById(String id);

    @Select("select * from permission")
    List<permission> findAll();

    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(permission permission);
}
