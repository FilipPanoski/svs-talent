package library.lendbook;

import library.book.Book;
import library.member.Member;

public interface Lending {

    void lendAndUpdate(Member member, Book book);
}
