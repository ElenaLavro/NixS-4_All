package com.company.userController;

import com.company.data.Author;
import com.company.data.Book;
import com.company.service.AuthorService;
import com.company.service.BookService;
import com.company.service.impl.AuthorServiceImpl;
import com.company.service.impl.BookServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserController {
    Scanner sc = new Scanner(System.in);
    BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
    private final Author author = new Author();
    private final BookService bookService = new BookServiceImpl();
    private final AuthorService authorService = new AuthorServiceImpl();

    public void menu() {
        System.out.println("Select the task you want to complete: ");
        System.out.println("1 - Create the book");
        System.out.println("2 - Create the author");
        System.out.println("3 - Update the information about the book");
        System.out.println("4 - Update the information about the author");
        System.out.println("5 - To read the information about the book");
        System.out.println("6 - To read the information about the author");
        System.out.println("7 - Delete the book");
        System.out.println("8 - Delete the author");
        System.out.println("9 - To see all books of the author");
        System.out.println("10 - To see all authors of the book");
        System.out.println("If you want to exit - type 0");
    }

    public void run() throws IOException {
        int num;
        do {
            menu();
            System.out.print("Your choice is: ");
            num = sc.nextInt();
            switch (num) {
                case 0 -> System.exit(0);
                case 1 -> {
                    createBook(myReader);
                    break;
                }
                case 2 -> {
                    createAuthor(myReader);
                    break;
                }
                case 3 -> {
                    UpdateTheBook(myReader);
                    break;
                }
                case 4 -> {
                    UpdateTheAuthor(myReader);
                    break;
                }
                case 5 -> {
                    ReadTheBook(sc);
                    break;
                }
                case 6 -> {
                    ReadTheAuthor(sc);
                    break;
                }
                case 7 -> {
                    DeleteBook(sc);
                    break;
                }
                case 8 -> {
                    DeleteAuthor(sc);
                    break;
                }
                case 9 -> {
                    AllBooksByAuthor(sc);
                    break;
                }
                case 10 -> {
                    AllAuthorsByBook(sc);
                    break;
                }
                default -> throw new IllegalStateException("Unexpected value: " + num);
            }
        } while (true);
    }

    private void createBook(BufferedReader myReader) throws IOException {
        Book book = new Book();
        System.out.println("Please, enter the title of the book:");
        String title = myReader.readLine();
        System.out.println("Enter authors separated by a coma (,)");
        String authorsAll = myReader.readLine();
        ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorsAll.split(",")));
        System.out.println("Please, enter the year of issue ");
        try {
            int yearOfIssue = sc.nextInt();
            if (yearOfIssue > 1200 && yearOfIssue <= 2021) {
                book.setTitle(title);
                book.setAuthors(authors);
                book.setYearOfIssue(yearOfIssue);
                bookService.create(book);
                System.out.println("The book was created\n");
            } else {
                System.out.println("Year of issue is wrong. Please, repeat your inputs\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input type of year\n");
        }

    }

    private void createAuthor(BufferedReader myReader) throws IOException {
        Author author = new Author();
        System.out.println("Please, enter the First name of author");
        String firstName = myReader.readLine();
        System.out.println("Please, enter the Last name of author");
        String lastName = myReader.readLine();
        System.out.println("Enter books separated by a coma(,)");
        String allBooks = myReader.readLine();
        ArrayList<String> books = new ArrayList<>(Arrays.asList(allBooks.split(",")));
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setBooks(books);
        authorService.createAuthor(author);
        System.out.println("The author was created \n");
    }

    private void UpdateTheBook(BufferedReader myReader) throws IOException {
        System.out.println("Enter the id of the book you want change");
        try {
            int id = sc.nextInt();
            Book book = bookService.read(id);
            System.out.println("Please, enter the new title of the book");
            String title = myReader.readLine();
            System.out.println("Enter new authors separated by a coma (,)");
            String authorsAll = myReader.readLine();
            ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorsAll.split(",")));
            System.out.println("Please, enter the year of issue ");
            int yearOfIssue = myReader.read();
            book.setTitle(title);
            book.setAuthors(authors);
            book.setYearOfIssue(yearOfIssue);
            bookService.update(book);
            System.out.println("Successful updating the book\n");

        } catch (NoSuchElementException elementException) {
            System.out.println("The id don`t exist. Firstly create the book\n");
        }


    }

    private void UpdateTheAuthor(BufferedReader myReader) throws IOException {
        System.out.println("Enter the id of the author you want to change");
        try {
            int id = sc.nextInt();
            author.setId(id);
            Author author = authorService.read(id);
                System.out.println("Please, enter the First name of author");
                String firstName = myReader.readLine();
                System.out.println("Please, enter the Last name of author");
                String lastName = myReader.readLine();
                System.out.println("Enter books separated by a coma(,)");
                String allBooks = myReader.readLine();
                ArrayList<String> books = new ArrayList<>(Arrays.asList(allBooks.split(",")));
                author.setFirstName(firstName);
                author.setLastName(lastName);
                author.setBooks(books);
                authorService.update(author);
                System.out.println("The author was successfully updated\n");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The author don't exist. Firstly, please create the Author\n");
        }

    }

    private void ReadTheBook(Scanner sc) {
        System.out.println("Enter the id-number of book you want to read");
        try {
            int id = sc.nextInt();
            System.out.println(bookService.read(id) + "\n");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The book don`t exist. Firstly create the book\n");
        }

    }

    private void ReadTheAuthor(Scanner sc) {
        System.out.println("Enter the id-number of author you want to read");
        try {
            int id = sc.nextInt();
            System.out.println(authorService.read(id) + "\n");

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The author don't exist. Firstly, please create the Author\n");
        }

    }

    private void DeleteBook(Scanner sc) {
        System.out.println("Enter the id-number of book you want to delete");
        try {
            int id = sc.nextInt();
            bookService.delete(id);
            System.out.println("Book deleted!!!\n");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The book don`t exist. Firstly create the book\n");
        }
    }

    private void DeleteAuthor(Scanner sc) {
        System.out.println("Enter the id-number of author you want to delete");
        try {
            int id = sc.nextInt();
            authorService.delete(id);
            System.out.println("Author deleted!!!\n");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The author don't exist. Firstly, please create the Author\n");
        }

    }

    private void AllBooksByAuthor(Scanner sc) {
        System.out.println("Enter the id-number of author");
        int id = sc.nextInt();
        authorService.createBooksFromAuthor(id);
    }

    private void AllAuthorsByBook(Scanner sc) {
        System.out.println("Enter the id-number of book");
        int id = sc.nextInt();
        bookService.createAuthorsFromBook(id);
    }


}
