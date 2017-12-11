package library.LendBook;

import library.book.Book;
import library.member.Member;
import library.book.BookRepository;
import library.member.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LendBook {

    public void lendBookToAMember(BookRepository bookRepository, MemberRepository memberRepository, Scanner scanner){
        System.out.print("Member name: ");
        String memberName = scanner.nextLine();
        System.out.print("Member surname: ");
        String memberSurname = scanner.nextLine();

        Member member = checkIfMemberExists(memberRepository, memberName, memberSurname);
        if (member == null){
            System.out.println("Member isn't registered!");
            return;
        }

        System.out.print("\n Book title: ");
        String bookTitle = scanner.nextLine();

        Book book = checkIfBookExists(bookRepository, bookTitle);
        if (book == null){
            System.out.println("Book isn't registered!");
            return;
        }

        member.getBooks().add(book);
        memberRepository.save(member);
        book.setMember(member);
        bookRepository.save(book);
        System.out.println("Book has been successfully lent!");
    }

    private Member checkIfMemberExists(MemberRepository memberRepository, String memberName, String memberSurname){
        Member member = memberRepository.findByNameAndAndSurname(memberName, memberSurname);
        if (member == null){
            return null;
        } else {
            return member;
        }
    }

    private Book checkIfBookExists(BookRepository bookRepository, String bookTitle){
        Book book = bookRepository.findByTitle(bookTitle);
        if (book == null){
            return null;
        } else {
            return book;
        }
    }
}
