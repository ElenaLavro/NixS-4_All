package com.company.service.impl;

import com.company.dao.AuthorDao;
import com.company.dao.impl.AuthorDaoImpl;
import com.company.data.Author;
import com.company.service.AuthorService;

import java.util.List;
import java.util.logging.Logger;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDaoService = new AuthorDaoImpl();
    private final Logger logger = Logger.getLogger(String.valueOf(BookServiceImpl.class));

    @Override
    public void createAuthor(Author author) {
        logger.info("Start creating the author");
        authorDaoService.createAuthor(author);
        logger.info("Creating the author is finished");
    }

    @Override
    public List<Author> readAll() {
        logger.info("Reading all authors");
        return authorDaoService.readAll();
    }

    @Override
    public Author read(int id) {
        logger.info("Reading the author by ID");
        isExistAuthor(id);
        return authorDaoService.read(id);
    }

    @Override
    public void update(Author author) {
        logger.info("Updating the author");
        isExistAuthor(author.getId());
        authorDaoService.update(author);
    }

    @Override
    public void delete(int id) {
        logger.info("Deleting the author");
        isExistAuthor(id);
        authorDaoService.delete(id);
    }

    @Override
    public void createBooksFromAuthor(int id) {
        logger.info("Creating books from author");
        authorDaoService.createBooksFromAuthor(id);
    }

    @Override
    public boolean isExistAuthor(int id) {
        logger.info("Checking author availability");
        Author author = authorDaoService.read(id);
        if (author == null) {
            System.out.println("404!!! The Author don't exist");
            return false;
        } else {
            return true;
        }
    }
}
