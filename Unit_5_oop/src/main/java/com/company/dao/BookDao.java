package com.company.dao;

import com.company.data.Book;

import java.util.List;

public interface BookDao {
    void create(Book book);

    void update(Book book);

    Book read(int id);

    List<Book> readALl();

    void delete(int id);

    void createAuthorsFromBook(int id);
}
