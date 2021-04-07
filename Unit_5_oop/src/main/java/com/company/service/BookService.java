package com.company.service;

import com.company.data.Book;

import java.util.List;

public interface BookService {
    void create(Book book);

    void update(Book book);

    Book read(int id);

    List<Book> readALl();

    void delete(int id);

    boolean isExistBook(int id);

    void createAuthorsFromBook(int id);
}
