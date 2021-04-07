package com.company.dao;

import com.company.data.Author;

import java.util.List;

public interface AuthorDao {
    void createAuthor(Author author);

    List<Author> readAll();

    Author read(int id);

    void update(Author author);

    void delete(int id);

    void createBooksFromAuthor(int id);
}
