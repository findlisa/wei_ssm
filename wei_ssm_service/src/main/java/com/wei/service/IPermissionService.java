package com.wei.service;

import com.wei.domain.permission;

import java.util.List;

public interface IPermissionService {
    List<permission> finaAll();

    void save(permission permission);
}
