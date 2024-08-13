package ums_servlet_01.dao;

import ums_servlet_01.po.User;
import ums_servlet_01.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class UserDaoImpl implements UserDao{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<User> selectAll(User u) {
        List<User> list = new ArrayList<>();
        String sql = "select * from t_user where 1=1";
        if(u.getUname()!=null && !"".equals(u.getUname())) {
            sql += " and uname like '%"+u.getUname()+"%'";
        }
        if(u.getDate()!=null && !"".equals(u.getDate())) {
            sql += " and birthdate like '%"+u.getDate()+"%'";
        }
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User u2 = new User();
                u2.setId( rs.getInt("id") );
                u2.setUname( rs.getString("uname") );
                u2.setPass( rs.getString("pass") );
                u2.setDate( rs.getString("birthday") );
                list.add(u2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }

    public User selectById(User u){
        User user = new User();
        String sql = "SELECT * FROM t_user WHERE id=?";
        try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, u.getId());
                    rs = ps.executeQuery();
                    while(rs.next()) {
                        user.setId(rs.getInt("id"));
                        user.setUname(rs.getString("uname"));
                        user.setPass(rs.getString("pass"));
                        user.setDate(rs.getString("birthday"));
        		    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
        return user;
    }

    public User selectByNameAndPass(User u){
        User user = new User();
        String sql = "SELECT * FROM t_user WHERE uname=? AND pass=?;";
        try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, u.getUname());
                    ps.setString(2, u.getPass());
                    rs = ps.executeQuery();
                    while(rs.next()) {
                        user.setId(rs.getInt("id"));
                        user.setUname(rs.getString("uname"));
                        user.setPass(rs.getString("pass"));
                        user.setDate(rs.getString("birthday"));
        		    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
        return user;
    }

    @Override
    public int removeUser(User u) {
        int i = 0;
        String sql = "DELETE FROM t_user WHERE id = ?;";
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, u.getId());
                    i =  ps.executeUpdate();
//                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return i;
    }

    @Override
    public int addUser(User u) {
        int i = 0;
        String sql = "INSERT INTO t_user VALUES(null, ?, ?, ?);";
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, u.getUname());
                    ps.setString(2, u.getPass());
                    ps.setString(3, u.getDate());
                    i =  ps.executeUpdate();
//                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return i;
    }

    @Override
    public int updateUser(User u) {
        int i = 0;
        String sql = "UPDATE t_user SET uname = ?, pass = ?, birthday = ? WHERE id = ?;";
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, u.getUname());
                    ps.setString(2, u.getPass());
                    ps.setString(3, u.getDate());
                    ps.setInt(4, u.getId());
                    i =  ps.executeUpdate();
//                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return i;
    }
}
