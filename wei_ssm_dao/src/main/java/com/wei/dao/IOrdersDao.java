package com.wei.dao;

import com.wei.domain.orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    //查询所有订单
    @Select("select*from orders")
    @Results({
            //主键
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select =
                    "com.wei.dao.IProductDao.findById"))
    })
    List<orders>findAll();
    //查询订单详情
    @Select("select * from orders where id=#{id}")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "orderNum", property = "orderNum"),
        @Result(column = "orderTime", property = "orderTime"),
        @Result(column = "orderStatus", property = "orderStatus"),
        @Result(column = "peopleCount", property = "peopleCount"),
        @Result(column = "payType", property = "payType"),
        @Result(column = "orderDesc", property = "orderDesc"),
        @Result(column = "productId", property = "product", one = @One(select =
                "com.wei.dao.IProductDao.findById")),
        @Result(column = "memberId",property = "member",one=@One(select = "com.wei.dao.IMemberDao.findById")),
            //一个订单可对应多个游客
        @Result(column = "id",property = "travellers",many=@Many(select = "com.wei.dao.ITravellerDao.findByOrdersId"))
    })
    orders findById(String id);
}
