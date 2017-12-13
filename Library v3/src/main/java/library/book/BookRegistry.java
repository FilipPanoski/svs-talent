package library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRegistry {

    @Autowired
    BookRepository bookRepository;

    public void registerNewBook(String isbn, String title){
        Book newBook = new Book(isbn, title);
        bookRepository.save(newBook);
    }
}
