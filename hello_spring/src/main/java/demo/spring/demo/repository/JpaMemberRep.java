package demo.spring.demo.repository;

import demo.spring.demo.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaMemberRep implements MemberRepository {

    // JPA는 Entity Manager로 동작한다.
    // jpa 라이브러리를 추가해놓기만 하면 스프링 부트가 자동으로 EntityManager를 생성해준다.
    // 우리는 만들어진 것을 주입만 받으면 된다.
    // 이전에 datasource로 했던 것(DB 연결 등)을 EntityManager가 다 관리한다.
    private final EntityManager em;

    public JpaMemberRep(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public Long remove(Long id) {
        Member member = em.find(Member.class, "id");
        em.remove(member);  // 트랜잭션 커밋시 반영됨.
        Member result = em.createQuery("delete from Member m where id = :id", Member.class)
                .setParameter("id", id).getSingleResult();
        return result.getId();
    }

    @Override
    public void clearMap() {

    }
}