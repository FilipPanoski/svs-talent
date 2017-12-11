package library.member;

import library.book.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowMember {

    public void showAllRegisteredMembers(MemberRepository memberRepository){
        System.out.println("All registered members: ");

        List<Member> allMembers = new ArrayList<>();
        memberRepository.findAll().forEach(allMembers::add);
        printAllRegisteredMembers(allMembers);
    }

    private void printAllRegisteredMembers(List<Member> allMembers){
        for (Member member : allMembers){
            System.out.print("Registered Member:: ");
            System.out.print("Name: " + member.getName());
            System.out.println(" Surname: " + member.getSurname());
            System.out.println("Lent books: ");
            printAllLentBooks(member);
        }
    }

    public void printAllLentBooks(Member member){
        List<Book> lentBooks = member.getBooks();
        int counter = 0;
        if (member.getBooks() != null) {
            for (Book book : lentBooks) {
                counter++;
                System.out.println(counter + "." + book.getTitle());
            }
        }
    }
}
