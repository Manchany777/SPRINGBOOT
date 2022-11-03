/*package demo.spring.demo;*/

import demo.spring.demo.repository.JdbcTemplateRep;
import demo.spring.demo.repository.MemberRepository;
import demo.spring.demo.repository.MemoryMemberRepository;
import demo.spring.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*@Configuration
public class SpringConfig {

    // 스프링이 properties에서 설정한 대로 DataSource를 빈으로 만들어준다.
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean          // @Bean : 컨테이너에 담는 부품들을 담는 역활
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();

        // JdbcTemplate을 사용하도록 바꿔준다
        return new JdbcTemplateRep(dataSource);
    }
}*/

// 수많은 부품들 중 긁어올 부품들을 SpringConfig에 모와두는 것