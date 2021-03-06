package com.wei.domain;

import com.wei.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class orders implements Serializable {

    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    //产品信息
    private product product;
    //游客信息
    private List<traveller> travellers;
    //会员信息
    private member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr= DateUtils.Date2String(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public com.wei.domain.product getProduct() {
        return product;
    }

    public void setProduct(com.wei.domain.product product) {
        this.product = product;
    }

    public List<traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<traveller> travellers) {
        this.travellers = travellers;
    }

    public member getMember() {
        return member;
    }

    public void setMember(member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
    public String getOrderStatusStr() {
        if(orderStatus==1){
            orderStatusStr="支付";
        }
        if(orderStatus==0){
            orderStatusStr="未支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }
}
