package com.wei.dao;

import com.wei.domain.member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    member findById(String id);
}
