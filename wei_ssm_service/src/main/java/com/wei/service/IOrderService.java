package com.wei.service;

import com.wei.domain.orders;

import java.util.List;

public interface IOrderService {
    public List<orders> findAll(Integer page,Integer size) throws Exception;

    orders findById(String id);
}
