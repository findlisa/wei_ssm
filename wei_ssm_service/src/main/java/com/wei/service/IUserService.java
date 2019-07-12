package com.wei.service;

import com.wei.domain.role;
import com.wei.domain.userInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<userInfo> findAll();

    void save(userInfo userInfo);

    userInfo findById(String id);

    List<role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] ids);
}
