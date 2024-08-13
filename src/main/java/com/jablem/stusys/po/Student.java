package com.jablem.stusys.po;

import sun.management.Agent;

public class Student {
    private Integer id;
    private String stuname;
    private String pass;
    private String birthdate;
    private String gender;
    private String age;
    private String address;
    private String phone;

    public Student() {
    }

    public Student(Integer id, String stuname, String pass, String birthdate, String gender, String age, String address, String phone) {
        this.id = id;
        this.stuname = stuname;
        this.pass = pass;
        this.birthdate = birthdate;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone = phone;
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
     * @return stuname
     */
    public String getStuname() {
        return stuname;
    }

    /**
     * 设置
     * @param stuname
     */
    public void setStuname(String stuname) {
        this.stuname = stuname;
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

    /**
     * 获取
     * @return birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * 设置
     * @param birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Student{id = " + id + ", stuname = " + stuname + ", pass = " + pass + ", birthdate = " + birthdate + ", gender = " + gender + ", age = " + age + ", address = " + address + ", phone = " + phone + "}";
    }
}
