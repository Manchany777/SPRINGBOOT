package demo.spring.demo.repository;

import demo.spring.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트는 각각 의존관계가 없이 각각 실행되도록 해야 한다. BeforeEach or AfterEach
    @BeforeEach
    public void map_initialize(){       //맵초기화
        repository.clearMap();
    }
// ※ Test시 3가지 법칙을 기억하라! given, when, then
    @Test
    // 테스트는 각각 의존관계가 없이 각각 실행되도록 해야 한다
    public void memberInfoSave(){    // 회원정보 저장 메소드를 테스트해보기 위함 (회원정보저장save)
        // given - 데이터가 주어지면
        Member member = new Member();
        member.setName("hello");
        repository.save(member);  // 위의 save랑 다른 save임
                // when - 데이터를 가져왔을 때
        Member result = repository.findById(member.getId()).get();
                // alt + enter : 지역변수 자동설정
                // member가 가지고 있는 getID를 찾아가기 위한 repository.findById => <1, hello>를 리턴
        // ※ 테스트 결과 확인하는 방법
        // 1. System.out.println(member == result); 로 확인하기
        // 2. junit의 jupiter에 있는 Assertions로 테스트 실행해보기
        //  Assertions.assertEquals(member, result);
        // 3. assertj에 있는 Assertion 선택후 static import 추가 => 이 방법을 권장
        // then - 주어진 데이터와 가져온 데이터가 맞으면 테스트 성공
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void allMembers() {  // findAll에 대한 테스트 (전체회원정보조회)
        // given - 데이터가 주어지면
        Member member = new Member();
        member.setName("hello");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("hello1");
        repository.save(member1);
        // when - 데이터를 가져왔을 때

        List<Member> result = repository.findAll();
        // then - 주어진 데이터와 가져온 데이터가 맞으면 테스트 성공
        assertThat(result.size()).isEqualTo(2);
    }
}
