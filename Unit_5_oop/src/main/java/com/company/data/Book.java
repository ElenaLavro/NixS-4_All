package com.company.data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Book extends Root {

    private String title;
    private List<String> authors;
    private int yearOfIssue;


    public Book() {
        super();
        this.authors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Book { " + "title is: '" + title + '\'' +
                ", id = '" + super.getId() + '\'' +
                ", year of issue is '" + yearOfIssue + '\'' + " the author is " +
                authors + '}';
    }
}
