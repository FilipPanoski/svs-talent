package library.member;

import library.book.Book;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Book> books = null;

    public Member(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Member(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
