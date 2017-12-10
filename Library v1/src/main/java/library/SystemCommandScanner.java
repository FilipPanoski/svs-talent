package library;

import library.book.RegisterBook;
import library.book.ShowBook;
import library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SystemCommandScanner {

    BookRepository bookRepository;
    RegisterBook registerBook;
    ShowBook showBook;

    private boolean isScanning = false;

    @Autowired
    public SystemCommandScanner(BookRepository bookRepository, RegisterBook registerBook, ShowBook showBook){
        this.bookRepository = bookRepository;
        this.registerBook = registerBook;
        this.showBook = showBook;
    }

    public void scanForCommands(){
        isScanning = true;
        while (isScanning){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command){
                case ("register"):
                    bookRepository.save(registerBook.registerNewBook(scanner));
                    break;
                case ("list"):
                    showBook.showAllRegisteredBooks(bookRepository);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
