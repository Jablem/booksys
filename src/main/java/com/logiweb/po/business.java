package com.logiweb.po;

public class business {
    private Integer businessid;
    private String businessname;
    private String password;

    public business() {
    }

    public business(Integer businessid, String businessname, String password) {
        this.businessid = businessid;
        this.businessname = businessname;
        this.password = password;
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
     * @return businessname
     */
    public String getBusinessname() {
        return businessname;
    }

    /**
     * 设置
     * @param businessname
     */
    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "business{businessid = " + businessid + ", businessname = " + businessname + ", password = " + password + "}";
    }
}
