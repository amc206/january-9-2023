package edu.greenriver.sdev.projectundervcs.controllers;

import edu.greenriver.sdev.projectundervcs.model.Book;
import edu.greenriver.sdev.projectundervcs.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class BookController
{
    private BookService service;

    public BookController(BookService service)
    {
        this.service = service;
    }

    //localhost:8080/books
    @GetMapping("books")
    public List<Book> getAllBooks()
    {
        return service.getAllBooks();
    }

    //localhost:8080/books/random
    @GetMapping("books/random") //getmapping says where data is located
    public Book getRandomBook()
    {
        return service.random();
    }

    //localhost:8080/books/by-name/will
    @GetMapping("books/by-name/{bookName}")
    public Book getBookByName(@PathVariable String bookName)
    {
        return service.byName(bookName);
    }

    //localhost:8080/books/by-pages/200
    @GetMapping("books/by-pages/{bookPages}")
    public Book getBookByPages(@PathVariable int bookPages)
    {
        return service.getBookByPages(bookPages);
    }

    //localhost:8080/books/by-page-total/200
    @GetMapping("books/by-page-total/{pageTotal}")
    public List<Book> getLongerBookByPages(@PathVariable int pageTotal)
    {
        return service.getLongerBookByPages(pageTotal);
    }

}
