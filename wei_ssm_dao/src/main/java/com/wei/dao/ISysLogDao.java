package com.wei.dao;

import com.wei.domain.sysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values" +
            "(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(sysLog sysLog);

    @Select("select * from syslog")
    List<sysLog> findAll();
}
