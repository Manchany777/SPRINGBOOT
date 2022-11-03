package demo.spring.demo.service;

import demo.spring.demo.domain.Member;
import demo.spring.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemoryMemberRepository repository;  // 선언
    MemberService service;

    /*@BeforeEach
     void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService();
    }*/

    @AfterEach
    void tearDown() {
        service.clearMap();
   }

    @Test
    void memberJoin() {
        // given
        Member member = new Member();
        member.setName("hello1");
        // when
        long id = service.memberJoin(member);
        Member result = repository.findById(id).get();
        // then
        System.out.println(result.getName());
        assertThat(member.getName()).isEqualTo(result.getName());   // member.getName()과 result.getName()가 같은지
    }

    @Test
    void findAllMembers() {
        //given -- 데이터가 주어지면
        Member member = new Member();
        member.setName("hello1");
        service.memberJoin(member);

        Member member1 = new Member();
        member.setName("hello2");
        service.memberJoin(member1);
        //when
        List<Member> results = service.findAllMembers();
    }
        //then

}