package com.wei.service.impl;

import com.wei.dao.IUserDao;
import com.wei.domain.role;
import com.wei.domain.userInfo;
import com.wei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao iUserDao;
    //用于登录的查询
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userInfo userInfo = iUserDao.findByUserName(username);
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus()==0?false:true,true,true,true,
                    getAuthorities(userInfo.getRoles()));
        return user;
    }
    //获取角色名字
    public List<SimpleGrantedAuthority> getAuthorities(List<role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<SimpleGrantedAuthority>();
        for (role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }
    //查询所有用户
    public List<userInfo> findAll() {
        List<userInfo> userInfos=iUserDao.findAll();
        return userInfos;
    }

    //添加用户
    public void save(userInfo userInfo) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    public userInfo findById(String id) {
        userInfo userInfo=iUserDao.findById(id);
        System.out.println(userInfo);
        return userInfo;
    }

    public List<role> findOtherRoles(String id) {
        List<role> roles=iUserDao.findOtherRoles(id);
        return roles;
    }

    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            iUserDao.addRoleToUser(userId,id);
        }

    }
}
