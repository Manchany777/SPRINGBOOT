package demo.spring.demo.repository;

import demo.spring.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
// 인터페이스 구현
public class MemoryMemberRepository implements MemberRepository{
    // hashmap<K, V> collection framework를 사용할 예정
    private static Map<Long, Member> map = new HashMap<>();
    private static Long sequence = 0L;    // 0으로 초기화 (*주의 : 숫자0 + Long = 0L)
    @Override
    public Member save(Member member) {
        sequence++;
        member.setId(sequence);
        map.put(sequence, member);
        return member;
    }

    // 매개변수로 들어온 id와 일치하는 값을 map에서 찾아서 이를 리턴한다.
    // NullpointException 발생하지 않도록 코드 단순화하기 위해 Optional.ofBullable()을 사용함
    // @param id
    // @return
    @Override
    public Optional<Member> findById(Long id) {
        map.get(id);
        return Optional.ofNullable(map.get(id));  // empty 대신 ofNullable() -> null일 경우 에러가 뜨지 않게
         // ofNullable() 메소드는 명시된 값이 null이 아니면 명시된 값을 가지는 Optional 객체를 반환하며, 명시된 값이 null이면 비어있는 Optional 객체를 반환합니다.
    }

    @Override
    public List<Member> findAll() {
        // 현재 hashmap에 들어있는 전체 value들을 다 가져와서
        // arrayList와 초기값으로 넣고 이를 리턴한다.
        /*ArrayList<Member> a = new ArrayList<>();
        a = map.values();
        return a;*/
        return new ArrayList<>(map.values());  // 위와 내용은 동일. 단, 생성하고 바로 던짐
    }

    @Override
    public Long remove(Long id) {
        return null;
    }

    // 진행 중 현재 map에 있는 모든 요소들을 다 삭제하기 위함
    public void clearMap(){
        map.clear();
    }

}
