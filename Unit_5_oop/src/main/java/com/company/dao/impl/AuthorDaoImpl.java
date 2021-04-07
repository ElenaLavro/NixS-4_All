package com.company.dao.impl;

import com.company.dao.AuthorDao;
import com.company.data.Author;
import com.company.db.LibraryDB;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {


    @Override
    public void createAuthor(Author author) {
        LibraryDB.getInstance().createAuthor(author);
    }

    @Override
    public List<Author> readAll() {
        return LibraryDB.getInstance().readAllAuthors();
    }

    @Override
    public Author read(int id) {
        return LibraryDB.getInstance().readAuthorById(id);
    }

    @Override
    public void update(Author author) {
        LibraryDB.getInstance().updateAuthor(author);
    }

    @Override
    public void delete(int id) {
        LibraryDB.getInstance().deleteAuthor(id);
    }

    @Override
    public void createBooksFromAuthor(int id) {
        LibraryDB.getInstance().createBooksFromAuthor(id);
    }

}
