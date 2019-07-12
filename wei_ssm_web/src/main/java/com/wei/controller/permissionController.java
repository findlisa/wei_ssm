package com.wei.controller;

import com.wei.domain.permission;
import com.wei.service.IPermissionService;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class permissionController {

    @Autowired
    IPermissionService iPermissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<permission> permissions=iPermissionService.finaAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;

    }

    @RequestMapping("/save.do")
    public String save(permission permission){
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }
}
