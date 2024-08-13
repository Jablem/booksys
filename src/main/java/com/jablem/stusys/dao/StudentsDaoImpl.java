package com.jablem.stusys.dao;

import com.jablem.stusys.po.Student;
import com.jablem.stusys.utils.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDaoImpl implements StudentDao{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<Student> selectAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setStuname(rs.getString("stuname"));
                stu.setPass(rs.getString("pass"));
                stu.setBirthdate(rs.getString("birthdate"));
                stu.setGender(rs.getString("gender"));
                stu.setAge(rs.getString("age"));
                stu.setAddress(rs.getString("address"));
                stu.setPhone(rs.getString("phone"));
                list.add(stu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public Student select(Student s) {
        Student stu = new Student();
        String sql = "select * from student where 1=1";
        if(s.getStuname() != null && !"".equals(s.getStuname())) {
            sql += " and stuname like '%"+s.getStuname()+"%'";
        }
        if(s.getBirthdate() != null && !"".equals(s.getBirthdate())) {
            sql += " and birthdate like '%"+s.getBirthdate()+"%'";
        }
        if (s.getGender() != null && !"".equals(s.getGender())) {
            sql += "and gender='"+s.getGender()+"'";
        }
        if(s.getAge() != null && !"".equals(s.getAge())) {
            sql += " and age='"+s.getAge()+"'";
        }
        if (s.getAddress() != null && !"".equals(s.getAddress())) {
            sql += "and address like '%"+s.getAddress()+"%'";
        }
        if (s.getAge() != null && !"".equals(s.getAge())) {
            sql += "and gender='"+s.getAge()+"'";
        }
        if(s.getPhone() != null && !"".equals(s.getPhone())) {
            sql += " and phone='"+s.getPhone()+"'";
        }
        if(s.getId() != null) {
            sql += " and id='"+s.getId()+"'";
        }
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                stu.setId(rs.getInt("id"));
                stu.setStuname(rs.getString("stuname"));
                stu.setPass(rs.getString("pass"));
                stu.setBirthdate(rs.getString("birthdate"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, ps, rs);
        }
        return stu;
    }

    @Override
    public Student selectByNameAndPass(Student s) {
        Student stu = new Student();
        String sql = "SELECT * FROM student WHERE stuname=? and pass=?;";
        try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, s.getStuname());
                    ps.setString(2, s.getPass());
                    rs = ps.executeQuery();
                    while(rs.next()) {
                        stu.setGender(rs.getString("gender"));
                        stu.setAge(rs.getString("age"));
                        stu.setAddress(rs.getString("address"));
                        stu.setPhone(rs.getString("phone"));
                        stu.setStuname(rs.getString("stuname"));
                        stu.setPass(rs.getString("pass"));
        		    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return stu;
    }

    @Override
    public int removeStudent(Student s) {
        int i = 0;
        String sql = "DELETE FROM student WHERE id = ?;";
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, s.getId());
                    i =  ps.executeUpdate();
                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return i;
    }

    @Override
    public int addStudent(Student s) {
        int i = 0;
        String sql = "insert into student(stuname, pass, birthdate, gender, age, address, phone) " +
                "values('"+s.getStuname()+"', '"+s.getPass()+"', '"
                +s.getBirthdate()+"', '"+s.getGender()+"', '"
                +s.getAge()+"', '"+s.getAddress()+"', '"
                +s.getPhone()+"');";
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    i =  ps.executeUpdate();
                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return i;
    }

    @Override
    public int updateStudent(Student s) {
        int i = 0;
        String sql = "update student set id="+s.getId()+", ";
        if(s.getStuname() != null && !"".equals(s.getStuname())) {
                    sql += "stuname='" + s.getStuname() + "'";
                }
        if(s.getPass() != null && !"".equals(s.getPass())) {
                    sql += ", pass='"+s.getPass()+"'";
                }
        if(s.getBirthdate() != null && !"".equals(s.getBirthdate())) {
                    sql += ", birthdate='"+s.getBirthdate()+ "'";
                }
        if(s.getGender() != null && !"".equals(s.getGender())) {
                    sql += ", gender='"+s.getGender()+"'";
        }
        if(s.getAge() != null && !"".equals(s.getAge())) {
                    sql += ", age='"+s.getAge()+"'";
                }
        if(s.getPhone() != null && !"".equals(s.getPhone())) {
                    sql += ", phone='"+s.getPhone()+"'";
                }
        if(s.getAddress() != null && !"".equals(s.getAddress())) {
                    sql += ", address='"+s.getAddress()+"'";
                }

        sql += "where id="+s.getId()+";";
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
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
