package library.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberListing {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getRegisteredMembers(){
        List<Member> allRegisteredMembers = new ArrayList<>();
        memberRepository.findAll().forEach(allRegisteredMembers::add);
        return allRegisteredMembers;
    }
}
