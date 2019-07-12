package com.wei.service;

import com.wei.domain.role;

import java.util.List;

public interface IRoleService {
    public List<role> findAll();

    void save(role role);
}
