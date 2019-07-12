package com.wei.controller;

import com.github.pagehelper.PageInfo;
import com.wei.domain.orders;
import com.wei.service.IOrderService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class orderController {

    @Autowired
    private IOrderService iOrderService;
//    订单查询未分页
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv=new ModelAndView();
//        List<orders> orders = iOrderService.findAll();
//        mv.addObject("ordersList",orders);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    //分页查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(value = "page") Integer page,@RequestParam(value = "size") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<orders> orders = iOrderService.findAll(page,size);
        //一个分页bean，帮助分页的
        PageInfo pageInfo=new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    //订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id") String id){
        ModelAndView mv=new ModelAndView();
        orders orderInfo=iOrderService.findById(id);
        mv.addObject("orders",orderInfo);
        mv.setViewName("orders-show");
        return mv;
    }
}
