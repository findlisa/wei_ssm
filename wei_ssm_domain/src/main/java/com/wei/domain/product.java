package com.wei.domain;

import com.wei.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class product implements Serializable {
    private String id; //主键
    private String productNum;//编号唯一
    private String productName;//名称
    private String cityName;//出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date   departureTime;//出发时间
    private String   departureTimeStr;
    private double productPrice;//价格
    private String productDesc;//描述
    private Integer productStatus;//状态
    private String productStatusStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {

        if(departureTime!=null){
           String  pattern="yyyy-MM-dd";
            departureTimeStr = DateUtils.Date2String(departureTime, pattern);
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String produtDesc) {
        this.productDesc = produtDesc;
    }

    public Integer getProductStatus() {

        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {

        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(productStatus!=null){
            if(productStatus==0){
                productStatusStr="关闭";
            }
            if(productStatus==1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
