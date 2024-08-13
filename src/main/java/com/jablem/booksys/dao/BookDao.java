package com.jablem.booksys.dao;

import com.jablem.booksys.po.Book;

import java.util.List;

public interface BookDao {
    public List<Book> selectAll(Book b);
    public int addBook(Book b);
    public int updateBook(Book b);
    public int removeBook(Book b);
}
