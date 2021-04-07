package com.company.db;

import com.company.data.Author;
import com.company.data.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryDB {
    private final List<Author> authorList = new ArrayList<>();
    private final List<Book> bookList = new ArrayList<>();

    private static LibraryDB lib;

    private LibraryDB() {
    }

    public static LibraryDB getInstance() {
        if (lib == null) {
            lib = new LibraryDB();
        }
        return lib;
    }

    public void createAuthor(Author author) {
        int size = authorList.size();
        int id = size + 1;
        author.setId(id);
        authorList.add(author);
    }

    public void createBook(Book book) {
        int size = bookList.size();
        int id = size + 1;
        book.setId(id);
        bookList.add(book);
    }

    public List<Author> readAllAuthors() {
        return authorList;
    }

    public List<Book> readAllBooks() {
        return bookList;
    }

    public Author readAuthorById(int id) {
        return authorList.stream().filter(author -> author.getId() == id).findFirst().get();
    }

    public Book readBookById(int id) {
        return bookList.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    public void updateAuthor(Author author) {
        Author cur = readAuthorById(author.getId());
        cur.setFirstName(author.getFirstName());
        cur.setLastName(author.getLastName());
    }

    public void updateBook(Book book) {
        Book cur = readBookById(book.getId());
        cur.setTitle(book.getTitle());
        cur.setAuthors(book.getAuthors());
        cur.setYearOfIssue(book.getYearOfIssue());
    }

    public void deleteAuthor(int id) {
        authorList.removeIf(author -> author.getId() == id);
    }

    public void deleteBook(int id) {
        bookList.removeIf(book -> book.getId() == id);
    }

    public void createBooksFromAuthor(int id) {
        System.out.println(bookList.stream().filter(b -> b.getAuthors().contains(id)).collect(Collectors.toList()));
    }

    public void createAuthorsFromBook(int id) {
        System.out.println(authorList.stream().filter(a -> a.getBooks().contains(id)).collect(Collectors.toList()));
    }
}
