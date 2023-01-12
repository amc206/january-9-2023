package edu.greenriver.sdev.projectundervcs.services;

import edu.greenriver.sdev.projectundervcs.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * This class will have our business logic.
 */
@Service
public class BookService
{
    private List<Book> booksList = List.of(
            new Book("Prince Harry","Spare",200),
            new Book("Mariah Carey","The Meaning of Mariah", 250),
            new Book("Will Smith","Will", 300),
            new Book("Kobe Bryant","Mamba Mentality", 350),
            new Book("Jimmy Evans","Tipping Point",150)
    );

    public List<Book> getAllBooks()
    {
        return booksList;
    }

    public Book random()
    {
        Random random = new Random();
        int randomIndex = random.nextInt(booksList.size());
        return booksList.get(randomIndex);
    }

    public Book byName(String name)
    {
        //left side of the arrow is parameter list right side is condition
        Book found = booksList.stream().filter(book -> book.getTitle().equalsIgnoreCase(name))
                .findFirst()
                .get();

        return found;
    }

    //write a route that provides a number of pages and return a book with that many pages or null if none
    public Book getBookByPages(int minPages)
    {
         Optional<Book> pagesFound = booksList.stream()
                .filter(book -> book.getPages() == minPages)
                .findFirst();

        return pagesFound.orElse(null);
        //return pagesFound.orElse(new Book("Error! Book not found!", "Not Found", 0)); //another way
    }

    //to search all books with larger page numbers
    public List<Book> getLongerBookByPages(int maxPages)
    {
        List<Book> totalPages = booksList.stream()
                .filter(book -> book.getPages() >= maxPages)
                //.sorted()
                //.distinct()
                .toList();

        return totalPages;
    }
}
