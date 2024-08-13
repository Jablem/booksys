package com.jablem.stusys.utils;

import java.sql.*;

public class DBUtil {//成品工具类，获取链接对象、释放资源
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:1919/school?characterEncoding=utf8";
        String username = "root";
        String password = "114514";
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection conn, Statement st, ResultSet rs){
        try{
            if(rs!=null) {rs.close();}
            if(st!=null) {st.close();}
            if(conn!=null) {conn.close();}
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
