package com.company.dao.impl;

import com.company.dao.BookDao;
import com.company.data.Book;
import com.company.db.LibraryDB;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void create(Book book) {
        LibraryDB.getInstance().createBook(book);
    }

    @Override
    public void update(Book book) {
        LibraryDB.getInstance().updateBook(book);
    }

    @Override
    public Book read(int id) {
        return LibraryDB.getInstance().readBookById(id);
    }

    @Override
    public List<Book> readALl() {
        return LibraryDB.getInstance().readAllBooks();
    }

    @Override
    public void delete(int id) {
        LibraryDB.getInstance().deleteBook(id);
    }

    @Override
    public void createAuthorsFromBook(int id) {
        LibraryDB.getInstance().createAuthorsFromBook(id);
    }
}
