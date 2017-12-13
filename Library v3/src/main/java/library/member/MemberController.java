package library.member;

import library.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberRegistry memberRegistry;
    @Autowired
    MemberListing memberListing;

    @PostMapping
    public String registerNewMember(@RequestParam("name") String name, @RequestParam("surname") String surname){
        memberRegistry.registerNewMember(name, surname);
        return name + " " + surname + " has been registered!";
    }

    @GetMapping
    public String showRegisteredMembers(){
        List<Member> allRegisteredMembers = memberListing.getRegisteredMembers();
        return makeAStringOfRegisteredMembers(allRegisteredMembers);
    }

    private String makeAStringOfRegisteredMembers(List<Member> allRegisteredMembers){
        StringBuilder memberList = new StringBuilder();
        String finalMemberList;
        int memberCounter = 0;
        for (Member member : allRegisteredMembers){
            memberCounter++;
            memberList.append(memberCounter + ". " + member.getName() + " " + member.getSurname() +
                    " \n- Lent books: " + makeAStringOfLentBooks(member) + "\n");
        }
        finalMemberList = memberList.toString();
        return finalMemberList;
    }

    private String makeAStringOfLentBooks(Member member){
        List<Book> memberBooks = member.getBooks();
        StringBuilder bookList = new StringBuilder();
        String finalBookList;
        for (Book book : memberBooks){
            bookList.append(book.getTitle() + "; ");
        }
        finalBookList = bookList.toString();
        return finalBookList;
    }
}
