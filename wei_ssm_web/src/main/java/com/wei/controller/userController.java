package com.wei.controller;

import com.wei.dao.IUserDao;
import com.wei.domain.role;
import com.wei.domain.userInfo;
import com.wei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private IUserService iUserService;

    //查询所有用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv =new ModelAndView();
        List<userInfo> userInfos=iUserService.findAll();
        mv.addObject("userList",userInfos);
        mv.setViewName("user-list");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(userInfo userInfo){
        iUserService.save(userInfo);
        return "redirect:findAll.do";
    }

    //查询用户详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id") String id){
        ModelAndView mv =new ModelAndView();
        userInfo userInfo=iUserService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //给用户查询可添加的角色
    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView mv =new ModelAndView();
        //查询用户信息
        userInfo user = iUserService.findById(id);
        //查询可添加的角色
        List<role> roleList=iUserService.findOtherRoles(id);

        mv.addObject("user",user);
        mv.addObject("roleList",roleList);

        mv.setViewName("user-role-add");
        return mv;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(value = "userId") String userId,@RequestParam(value = "ids") String[] ids){
            iUserService.addRoleToUser(userId,ids);
            return "redirect:findAll.do";
        }


}
