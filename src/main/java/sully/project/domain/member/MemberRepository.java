package sully.project.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;

    public Member save(Member member){   //회원 저장 메서드
        member.setId(++sequence);        //멤버가 저장될 때 아이디 값이 1씩 증가
        log.info("save: member ={}" , member);
        store.put(member.getId(), member);  //Map은 put 메서드를 사용하여 키와 값을 담아준다.
        return member;
    }

    public Member findById(Long id){
        return store.get(id);    //Map이기 때문에 id인 키를 넣으면 값 벨류인 Member을 뺄 수 있음.
    }

    public List<Member> findAll(){   //전체 찾는 메서드
        return new ArrayList<>(store.values());
    }

    //로그인 아이디로 찾는 메서드
    public Optional<Member> findByLoginId(String loginId){  //Optional인 이유는 못찾을 수도 있기 때문.
        List<Member> all = findAll();
        for(Member  m : all){
           if(m.getLoginId().equals(loginId)){
               return Optional.of(m);
           }
        }
        return Optional.empty();
    }
    public void clearStore(){
        store.clear();
    }
}
