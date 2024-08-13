package com.jablem.booksys.service;

import com.jablem.booksys.po.Book;

import java.util.List;

public interface BookService {
    public List<Book> selectAll(Book b);
    public int addBook(Book b);
    public int updateBook(Book b);
    public int removeBook(Book b);
}
