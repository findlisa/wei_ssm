package com.wei.service.impl;

import com.wei.dao.IPermissionDao;
import com.wei.domain.permission;
import com.wei.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class permissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;
    public List<permission> finaAll() {
       List<permission> permissions=iPermissionDao.findAll();
       return permissions;
    }

    public void save(permission permission) {
        iPermissionDao.save(permission);
    }
}
