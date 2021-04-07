package com.company.service.impl;

import com.company.dao.BookDao;
import com.company.dao.impl.BookDaoImpl;
import com.company.data.Book;
import com.company.service.BookService;
import org.apache.log4j.Logger;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDao bookDaoService = new BookDaoImpl();
    private final Logger logger = Logger.getLogger(BookServiceImpl.class);

    @Override
    public void create(Book book) {
        logger.info("Start creating the book");
        bookDaoService.create(book);
        logger.info("Finish creating the book");
    }

    @Override
    public void update(Book book) {
        logger.info("Updating the book");
        isExistBook(book.getId());
        bookDaoService.update(book);

    }

    @Override
    public Book read(int id) {
        logger.info("Reading the book by ID");
        isExistBook(id);
        return bookDaoService.read(id);
    }

    @Override
    public List<Book> readALl() {
        logger.info("Reading all books");
        return bookDaoService.readALl();
    }

    @Override
    public void delete(int id) {
        logger.info("Deleting the book");
        isExistBook(id);
        bookDaoService.delete(id);
    }

    @Override
    public void createAuthorsFromBook(int id) {
        logger.info("Start creating Authors from the book");
        bookDaoService.createAuthorsFromBook(id);
        logger.info("Finished creating Authors from the book");
    }

    @Override
    public boolean isExistBook(int id) {
        logger.info("Checking the book availability");
        Book book = bookDaoService.read(id);
        if (book == null) {
            System.out.println("404!!! The book don't exist");
            return false;
        } else {
            return true;
        }
    }
}