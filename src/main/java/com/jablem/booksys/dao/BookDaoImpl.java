package com.jablem.booksys.dao;

import com.jablem.booksys.po.Book;
import com.jablem.booksys.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class BookDaoImpl implements BookDao{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<Book> selectAll(Book b) {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book where 1=1";
        if (b.getTitle()!= null && !"".equals(b.getTitle())){
            sql += "and title like '%" + b.getTitle() + "%'";
        }
        if (b.getAuthor()!= null && !"".equals(b.getAuthor())){
            sql += "and title like '%" + b.getAuthor() + "%'";
        }
        if (b.getIsbn()!= null && !"".equals(b.getIsbn())){
            sql += "and title like '%" + b.getIsbn() + "%'";
        }
                try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    rs = ps.executeQuery();
                    while (rs.next()){
                        Book bb = new Book();
                        bb.setId(rs.getInt("id"));
                        bb.setTitle(rs.getString("title"));
                        bb.setAuthor(rs.getString("author"));
                        bb.setIsbn(rs.getString("isbn"));
                    }
                    int i =  ps.executeUpdate();
                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return list;
    }

    @Override
    public int addBook(Book b) {
        int i = 0;
        String sql = "INSERT INTO book(title, author, isbn) VALUES (?,?,?);";
        try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,b.getTitle());
                    ps.setString(2,b.getAuthor());
                    ps.setString(3,b.getIsbn());
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
    public int updateBook(Book b) {
        int i = 0;
        String sql = "UPDATE book SET title=?, author=? WHERE isbn=?";
        try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,b.getTitle());
                    ps.setString(2,b.getAuthor());
                    ps.setString(3,b.getIsbn());
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
    public int removeBook(Book b) {
        int i = 0;
        String sql = "DELETE FROM book WHERE isbn=?;";
        try{
                    conn = DBUtil.getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,b.getIsbn());
                    i =  ps.executeUpdate();
                    System.out.println("i =" + i);
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DBUtil.close(conn, ps, rs);
                }
                return i;

    }
}
