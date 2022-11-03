package demo.spring.demo.repository;

import demo.spring.demo.domain.Member;

import java.util.List;
import java.util.Optional;

/*회원객체를 저장하고 조회하기 위한 기능 구현 인터페이스*/

public interface MemberRepository {
    // 메소드를 3개 기능만 정의, 내용은 없음
    Member save(Member member);

    /*Optional<T> 클래스*/
    /*없으면 null 을 그대로 반환하지 않고 optional로
    NullpointException 발생하지 않게 하려면
        if (member == null) return ~~
        else return member;*/
    Optional<Member> findById(Long id);

    List<Member> findAll();

    Long remove(Long id);     // 반환값 데이터 타입 확인 필요
    void clearMap();
}

