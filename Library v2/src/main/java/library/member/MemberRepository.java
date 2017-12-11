package library.member;

import library.member.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByNameAndAndSurname(String name, String surname);
}
