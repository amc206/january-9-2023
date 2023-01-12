package edu.greenriver.sdev.projectundervcs;

import edu.greenriver.sdev.projectundervcs.model.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectUnderVcsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectUnderVcsApplication.class, args);

        Book book = new Book("Spare", "Prince Harry", 300);
        Book defaultBook = new Book();
        Book builtBook = Book.builder()
                .author("Mariah Carey")
                .title("The Meaning of Mariah")
                .pages(350)
                .build();
    }
}
