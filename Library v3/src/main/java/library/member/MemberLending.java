package library.member;

import library.lendbook.Lending;
import library.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberLending implements Lending {

    @Autowired
    MemberRepository memberRepository;

    public Member getMember(String name, String surname){
        return memberRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public void lendAndUpdate(Member member, Book book){
        member.getBooks().add(book);
        memberRepository.save(member);
    }
}
