package library.book;

import library.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRegistry bookRegistry;
    @Autowired
    BookListing bookListing;

    @PostMapping
    public String registerNewBook(@RequestParam("isbn") String isbn, @RequestParam("title") String title){
        bookRegistry.registerNewBook(isbn, title);
        return title + " has been registered!";
    }

    @GetMapping
    public String showRegisteredBooks(){
        List<Book> allRegisteredBooks = bookListing.getRegisteredBooks();
        return makeAStringOfRegisteredBooks(allRegisteredBooks);
    }

    private String makeAStringOfRegisteredBooks(List<Book> allRegisteredBooks){
        StringBuilder bookList = new StringBuilder();
        String finalBookList;
        int bookCounter = 0;
        for (Book book : allRegisteredBooks){
            bookCounter++;
            bookList.append(bookCounter + ". " + book.getTitle() + " " + book.getIsbn() + checkIfBookIsLent(book));
        }
        finalBookList = bookList.toString();
        return finalBookList;
    }

    private String checkIfBookIsLent(Book book){
        Member member = book.getMember();
        if (member == null){
            return " Lenders: none";
        } else {
            return " Lenders: " + book.getMember().getName() + " " + book.getMember().getSurname() + "\n";
        }
    }
}
