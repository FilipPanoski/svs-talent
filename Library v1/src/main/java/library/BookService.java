package library;

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
        System.out.println(" 'register' - register a new book \n" +
        " 'list' - show all registered books");
    }
}
