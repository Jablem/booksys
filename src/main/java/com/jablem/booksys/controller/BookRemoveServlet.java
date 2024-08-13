package com.jablem.booksys.controller;

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
import java.util.List;

@WebServlet("/remove-book")
//  http://localhost:8080/update-book?title=水浒传&query=978012345678
public class BookRemoveServlet extends HttpServlet {
    private final BookService service = new BookServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//保证前台提交汉字不乱码
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");//向浏览器输出汉字不乱码

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String isbn  = req.getParameter("isbn");
        Book book = new Book(null,title,author,isbn);

        Book b2 = new Book();
        b2.setIsbn(isbn);
        List<Book> list = service.selectAll(b2);
        String result = "";
        if (list.isEmpty()){
            result = "图书不存在！";
        }else {
            int i = service.removeBook(book);
            if (i > 0){
                result = "删除图书成功！";
            }
        }

        PrintWriter out = resp.getWriter();
        out.println(result);
        out.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
