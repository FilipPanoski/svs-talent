package library.book;

import library.lendbook.Lending;
import library.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookLending implements Lending{

    @Autowired
    BookRepository bookRepository;

    public Book getBook(String title){
        return bookRepository.findByTitle(title);
    }

    @Override
    public void lendAndUpdate(Member member, Book book) {
        book.setMember(member);
        bookRepository.save(book);
    }
}
