package ums_servlet_01.po;

public class User {
    private Integer id;
    private String uname;
    private String pass;
    private String date;

    public User() {
    }

    public User(Integer id, String uname, String pass, String date) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.date = date;
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
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * 设置
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
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
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "User{id = " + id + ", uname = " + uname + ", pass = " + pass + ", date = " + date + "}";
    }
}
