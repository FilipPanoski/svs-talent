package library.book;

import library.book.Book;
import library.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowBook {

    public void showAllRegisteredBooks(BookRepository bookRepository){
        System.out.println("All registered books: ");

        List<Book> allBooks = new ArrayList<>();
        bookRepository.findAll().forEach(allBooks::add);

        for (Book book : allBooks){
            System.out.print("Registered Book:: ");
            System.out.print("Title: " + book.getTitle());
            System.out.println(" ISBN: " + book.getIsbn());
        }
    }
}
