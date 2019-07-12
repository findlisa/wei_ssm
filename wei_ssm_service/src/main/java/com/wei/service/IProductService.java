package com.wei.service;

import com.wei.domain.product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<product> findAll() throws Exception;
    void save(product product)throws Exception;
}
