package com.wei.service.impl;

import com.wei.dao.IRoleDao;
import com.wei.domain.role;
import com.wei.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    public List<role> findAll() {
        List<role>roles=iRoleDao.findAll();
        return roles;
    }

    public void save(role role) {
        iRoleDao.save(role);
    }
}
