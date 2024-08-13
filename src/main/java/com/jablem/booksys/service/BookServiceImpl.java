package com.jablem.booksys.service;

import com.jablem.booksys.dao.BookDao;
import com.jablem.booksys.dao.BookDaoImpl;
import com.jablem.booksys.po.Book;

import java.util.List;

public class BookServiceImpl implements BookService{
    private final BookDao dao = new BookDaoImpl();
    @Override
    public List<Book> selectAll(Book b) {
        return dao.selectAll(b);
    }

    @Override
    public int addBook(Book b) {
        return dao.addBook(b);
    }

    @Override
    public int updateBook(Book b) {
        return dao.updateBook(b);
    }

    @Override
    public int removeBook(Book b) {
        return dao.removeBook(b);
    }
}
