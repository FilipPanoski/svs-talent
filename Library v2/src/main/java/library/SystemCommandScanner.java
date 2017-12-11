package library;

import library.LendBook.LendBook;
import library.book.RegisterBook;
import library.book.ShowBook;
import library.member.RegisterMember;
import library.member.ShowMember;
import library.book.BookRepository;
import library.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SystemCommandScanner {

    BookRepository bookRepository;
    RegisterBook registerBook;
    ShowBook showBook;

    MemberRepository memberRepository;
    RegisterMember registerMember;
    ShowMember showMember;

    private LendBook lendBook;
    private boolean isScanning = false;

    @Autowired
    public SystemCommandScanner(BookRepository bookRepository, RegisterBook registerBook, ShowBook showBook,
                                MemberRepository memberRepository, RegisterMember registerMember, ShowMember showMember,
                                LendBook lendBook){
        this.bookRepository = bookRepository;
        this.registerBook = registerBook;
        this.showBook = showBook;
        this.memberRepository = memberRepository;
        this.registerMember = registerMember;
        this.showMember = showMember;
        this.lendBook = lendBook;
    }

    public void scanForCommands(){
        isScanning = true;
        while (isScanning){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command){
                case ("register book"):
                    bookRepository.save(registerBook.registerNewBook(scanner));
                    break;
                case ("list books"):
                    showBook.showAllRegisteredBooks(bookRepository);
                    break;
                case ("register member"):
                    memberRepository.save(registerMember.registerNewMember(scanner));
                    break;
                case ("list members"):
                    showMember.showAllRegisteredMembers(memberRepository);
                    break;
                case ("lend book"):
                    lendBook.lendBookToAMember(bookRepository, memberRepository, scanner);
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
