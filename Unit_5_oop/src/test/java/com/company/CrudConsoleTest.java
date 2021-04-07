package com.company;


import com.company.data.Author;
import com.company.data.Book;
import com.company.service.AuthorService;
import com.company.service.BookService;
import com.company.service.impl.AuthorServiceImpl;
import com.company.service.impl.BookServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudConsoleTest {
    private static final BookService BOOK_SERVICE = new BookServiceImpl();
    private static final AuthorService AUTHOR_SERVICE = new AuthorServiceImpl();

    @Test
    @BeforeAll
    public void init() {
        for (int i = 0; i < 10; i++) {
            String s = "Test " + i;
            Book book = new Book();
            book.setId(i);
            book.setTitle(s);
            book.setYearOfIssue(i + 2000);
            BOOK_SERVICE.create(book);

            Author author = new Author();
            author.setId(i);
            author.setFirstName("My first name" + i);
            author.setLastName("My last name " + i);
            AUTHOR_SERVICE.createAuthor(author);
        }
        Assert.assertEquals(BOOK_SERVICE.readALl().size(), AUTHOR_SERVICE.readAll().size());
    }

    @Test
    @Order(1)
    public void createBook() {
        int size = BOOK_SERVICE.readALl().size();
        Book book = new Book();
        book.setTitle("Test Title");
        List<String> myAuthors = new ArrayList<>();
        myAuthors.add("Mark Twen");
        myAuthors.add("John Smite");
        book.setAuthors(myAuthors);
        book.setYearOfIssue(2000);
        BOOK_SERVICE.create(book);
        Assert.assertEquals(size + 1, BOOK_SERVICE.readALl().size());
    }

    @Test
    @Order(2)
    public void createAuthor() {
        int size = AUTHOR_SERVICE.readAll().size();
        Author author = new Author();
        author.setFirstName("First Test Name");
        author.setLastName("Second Test Name");
        List<String> myBooks = new ArrayList<>();
        myBooks.add("My first test book");
        myBooks.add("My second test book");
        myBooks.add("My third test book");
        myBooks.add("My fourth test book");
        author.setBooks(myBooks);
        AUTHOR_SERVICE.createAuthor(author);
        Assert.assertEquals(size + 1, AUTHOR_SERVICE.readAll().size());
    }

    @Test
    @Order(3)
    public void readAllBooks() {
        BOOK_SERVICE.readALl();
    }

    @Test
    @Order(4)
    public void readAllAuthors() {
        AUTHOR_SERVICE.readAll();
    }

    @Test
    @Order(5)
    public void updateTheBook() {
        int id = BOOK_SERVICE.readALl().size() - 2;
        BOOK_SERVICE.isExistBook(id);
        Book book = BOOK_SERVICE.read(id);
        book.setTitle("My new Test Title");
        book.setYearOfIssue(2003);
        List<String> myNewAuthors = new ArrayList<>();
        myNewAuthors.add("First new Test Author");
        myNewAuthors.add("Second new Test Author");
        book.setAuthors(myNewAuthors);
        BOOK_SERVICE.update(book);
        try {
            Assert.assertEquals("My new Test Title", BOOK_SERVICE.read(id).getTitle());
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }

    @Test
    @Order(6)
    public void updateTheAuthor() {
        createAuthor();
        int id = AUTHOR_SERVICE.readAll().size();
        AUTHOR_SERVICE.isExistAuthor(id);
        Author author = AUTHOR_SERVICE.read(id);
        author.setFirstName("NewTestFirstName");
        author.setLastName("NewTestLastName");
        List<String> myNewBooks = new ArrayList<>();
        myNewBooks.add("My new first test book");
        myNewBooks.add("My new second test book");
        myNewBooks.add("My new third test book");
        author.setBooks(myNewBooks);
        AUTHOR_SERVICE.update(author);
        try {
            Assert.assertTrue(AUTHOR_SERVICE.read(id).getFirstName().equals("NewTestFirstName") && (AUTHOR_SERVICE.read(id).getLastName().equals("NewTestLastName")));
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }

    @Test
    @Order(7)
    public void deleteTheBook() {
        createBook();
        int id = BOOK_SERVICE.readALl().size();
        System.out.println("the id is " + id);
        if (BOOK_SERVICE.isExistBook(id)) {
            BOOK_SERVICE.delete(id);
        } else {
            throw new NoSuchElementException("The book don't exist");
        }
    }

    @Test
    @Order(8)
    public void readBookByID() {
        int id = BOOK_SERVICE.readALl().size();
        BOOK_SERVICE.read(id);
    }

    @Test
    @Order(9)
    public void deleteTheAuthor() {
        init();
        int id = AUTHOR_SERVICE.readAll().size() - 1;
        if (AUTHOR_SERVICE.isExistAuthor(id)) {
            AUTHOR_SERVICE.delete(id);
        } else {
            throw new NoSuchElementException("Author don't exist");
        }
    }

    @Test
    @Order(10)
    public void allAuthorsByBook() {
        int id = BOOK_SERVICE.readALl().size();
        BOOK_SERVICE.createAuthorsFromBook(id);
    }

    @Test
    @Order(11)
    public void allBooksByAuthor() {
        int id = AUTHOR_SERVICE.readAll().size();
        AUTHOR_SERVICE.createBooksFromAuthor(id);
    }
}
