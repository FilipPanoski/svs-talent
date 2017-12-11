package library.book;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowBook {

    public void showAllRegisteredBooks(BookRepository bookRepository){
        System.out.println("All registered books: ");

        List<Book> allBooks = new ArrayList<>();
        bookRepository.findAll().forEach(allBooks::add);
        printAllRegisteredBooks(allBooks);
    }

    private void printAllRegisteredBooks(List<Book> allBooks){
        for (Book book : allBooks){
            System.out.print("Registered Book:: ");
            System.out.print("Title: " + book.getTitle());
            System.out.print(" ISBN: " + book.getIsbn());
            checkIfHasAMemberAndPrintResult(book);
        }
    }

    private void checkIfHasAMemberAndPrintResult(Book book){
        if (book.getMember() != null)
            System.out.println(" Lent to member: " + book.getMember().getName() + " " + book.getMember().getSurname());
        else {
            System.out.println(" Lent to member: None");
        }
    }
}
