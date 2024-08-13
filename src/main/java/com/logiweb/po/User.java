package com.logiweb.po;

public class User {
    private Integer userid;
    private String username;
    private String password;

    public User() {
    }

    public User(Integer userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
        return "User{userid = " + userid + ", username = " + username + ", password = " + password + "}";
    }
}
