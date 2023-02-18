package sully.project.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sully.project.domain.member.Member;
import sully.project.domain.member.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
        Member member= findMemberOptional.get();
        if(member.getPassword().equals(password)){
            return member;
        }else{
            return null;
        }
     }


}
