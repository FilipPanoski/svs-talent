package library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookListing {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getRegisteredBooks(){
        List<Book> allRegisteredBooks = new ArrayList<>();
        bookRepository.findAll().forEach(allRegisteredBooks::add);
        return allRegisteredBooks;
    }
}
