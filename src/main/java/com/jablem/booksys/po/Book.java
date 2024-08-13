package com.jablem.booksys.po;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String isbn;


    public Book() {
    }

    public Book(Integer id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * 设置
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String toString() {
        return "Book{id = " + id + ", title = " + title + ", author = " + author + ", isbn = " + isbn + "}";
    }
}
