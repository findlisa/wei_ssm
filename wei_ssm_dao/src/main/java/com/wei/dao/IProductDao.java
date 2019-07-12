package com.wei.dao;

import com.wei.domain.product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    //查询所有
    @Select("select * from product")
    List<product> findAll() throws Exception;

    //根据id查询
    @Select("select * from product where id=#{id}")
    product findById(String id);

    //插入产品
    @Insert("insert into product" +
            "(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values " +
            "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(product product);
}
