package com.company.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Author extends Root {
    public String firstName;
    public String lastName;
    public List<String> books;

    public Author() {
        super();
        this.books = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Author {" + " first name is '" + firstName +
                '\'' + " last name is '" + lastName + '\'' +
                " id= '" + super.getId() + '\'' + " list of book is: " +
                books + " }";
    }
}
