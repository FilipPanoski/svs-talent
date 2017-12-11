package library.book;

import library.book.Book;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterBook {

    public Book registerNewBook(Scanner scanner){
        System.out.println("Registering a new book...");

        System.out.print("Enter book ISBN: ");
        String bookISBN = scanner.nextLine();

        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        System.out.println(bookTitle + " has been registered!");

        return new Book(bookISBN, bookTitle);
    }
}
