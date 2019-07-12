package com.wei.controller;


import com.wei.domain.role;
import com.wei.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/role")
@Controller
public class roleController {

    @Autowired
    IRoleService iRoleService;
    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<role> roles=iRoleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(role role){
        iRoleService.save(role);
        return "redirect:findAll.do";
    }
}
