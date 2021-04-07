package com.company.service;

import com.company.data.Author;

import java.util.List;

public interface AuthorService {
    void createAuthor(Author author);

    List<Author> readAll();

    Author read(int id);

    void update(Author author);

    void delete(int id);

    boolean isExistAuthor(int id);

    void createBooksFromAuthor(int id);
}
