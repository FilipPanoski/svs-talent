package library.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegistry {

    @Autowired
    MemberRepository memberRepository;

    public void registerNewMember(String name, String surname){
        Member newMember = new Member(name, surname);
        memberRepository.save(newMember);
    }
}
