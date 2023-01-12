package edu.greenriver.sdev.projectundervcs.controllers;

import edu.greenriver.sdev.projectundervcs.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController
{
    private List<Book> booksList = List.of(
            new Book("Spare", "Prince Harry",200),
            new Book("The Meaning of Mariah", "Mariah Carey", 250),
            new Book("Will", "Will Smith", 300),
            new Book("Mamba Mentality", "Kobe Bryant", 350),
            new Book("Tipping Point", "Jimmy Evans",150)
    );

    @GetMapping("books")
    public List<Book> getAllBooks()
    {
        return booksList;
    }
}
