package com.logiweb.po;

public class admin {
    private Integer id;
    private String name;
    private String pass;

    public admin() {
    }

    public admin(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * 设置
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString() {
        return "admin{id = " + id + ", name = " + name + ", pass = " + pass + "}";
    }
}
