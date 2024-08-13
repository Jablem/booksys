package com.logiweb.po;

public class order {
    private Integer orderid;
    private Integer userid;
    private Integer businessid;
    private Integer status;
    private double price;
    private String orderdate;

    public order() {
    }

    public order(Integer orderid, Integer userid, Integer businessid, Integer status, double price, String orderdate) {
        this.orderid = orderid;
        this.userid = userid;
        this.businessid = businessid;
        this.status = status;
        this.price = price;
        this.orderdate = orderdate;
    }

    /**
     * 获取
     * @return orderid
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 设置
     * @param orderid
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 获取
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取
     * @return businessid
     */
    public Integer getBusinessid() {
        return businessid;
    }

    /**
     * 设置
     * @param businessid
     */
    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return orderdate
     */
    public String getOrderdate() {
        return orderdate;
    }

    /**
     * 设置
     * @param orderdate
     */
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String toString() {
        return "order{orderid = " + orderid + ", userid = " + userid + ", businessid = " + businessid + ", status = " + status + ", price = " + price + ", orderdate = " + orderdate + "}";
    }
}
