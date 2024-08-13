package com.jablem.booksys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jablem.booksys.po.Book;
import com.jablem.booksys.service.BookService;
import com.jablem.booksys.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search-book")
//  http://localhost:8080/search-book?title=水浒传&query=978012345678
public class BookQueryServlet extends HttpServlet {
    private final BookService service = new BookServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//保证前台提交汉字不乱码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");//向浏览器输出汉字不乱码

        String title = req.getParameter("title");
        String isbn  = req.getParameter("isbn");
        Book book = new Book(null,title,null,isbn);

        List<Book> list = new ArrayList<>();

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.println(om.writeValueAsString(list));
        out.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
