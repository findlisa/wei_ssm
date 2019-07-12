package com.wei.service.impl;

import com.wei.dao.IProductDao;
import com.wei.domain.product;
import com.wei.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class productServiceImpl implements IProductService {
    //自动注入
    @Autowired
    private IProductDao productDao;
    //查询
    public List<product> findAll() throws Exception {
        List<product> products = productDao.findAll();
        return products;
    }
    //插入
    public void save(product product) throws Exception {
        productDao.save(product);
    }
}
