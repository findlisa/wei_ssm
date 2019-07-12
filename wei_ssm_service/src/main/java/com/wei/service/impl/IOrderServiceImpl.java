package com.wei.service.impl;

import com.github.pagehelper.PageHelper;
import com.wei.dao.IOrdersDao;
import com.wei.domain.orders;
import com.wei.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrdersDao iOrdersDao;
    //查询所有，不分页
//    public List<orders> findAll() throws Exception {
//        PageHelper.startPage(1,3);
//        List<orders> orders = iOrdersDao.findAll();
//        return orders;
//    }

    //查询所有分页
    public List<orders> findAll(Integer page,Integer size) throws Exception {
        //从第一页开始，每页显示3条
        PageHelper.startPage(page,size);
        List<orders> orders = iOrdersDao.findAll();
        return orders;
    }
    //订单详情
    public orders findById(String id) {
        orders orderInfo=iOrdersDao.findById(id);
        System.out.println(orderInfo);
        return orderInfo;
    }
}
