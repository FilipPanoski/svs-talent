package library;

import library.SystemCommandScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    SystemCommandScanner systemCommandScanner;

    public void startApplication(){
        showInitMessage();
        systemCommandScanner.scanForCommands();
    }

    private void showInitMessage(){
        System.out.println("Welcome to the Library App!");
        System.out.println("Commands: ");
        System.out.println(" 'register book' - register a new book \n" +
        " 'list books' - show all registered books \n" + " 'register member' - register a new member \n" +
        " 'list members' - show all registered members \n" + " 'lend book' - lend a book to a member");
    }
}
