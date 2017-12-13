package library.lendbook;

import library.book.Book;
import library.book.BookLending;
import library.member.Member;
import library.member.MemberLending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lend-books-to-members")
public class LendBookToMember {

    @Autowired
    MemberLending memberLending;
    @Autowired
    BookLending bookLending;

    @PutMapping
    @ResponseBody
    public String lendBookToAMember(@RequestParam("name") String memberName, @RequestParam("surname") String memberSurname,
                                    @RequestParam("title") String bookTitle){

        Member member = memberLending.getMember(memberName, memberSurname);
        if (member == null){
            return memberName + " " + memberSurname + " isn't registered!";
        }

        Book book = bookLending.getBook(bookTitle);
        if (book == null){
            return bookTitle + " isn't registered!";
        }

        memberLending.lendAndUpdate(member, book);
        bookLending.lendAndUpdate(member, book);
        return "Book has been successfully lent!";
    }
}
