package com.wei.dao;

import com.wei.domain.traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    @Select("SELECT*FROM TRAVELLER WHERE ID IN(SELECT TRAVELLERID FROM ORDER_TRAVELLER WHERE ORDERID=#{id})")
    List<traveller> findByOrdersId(String id);
}
