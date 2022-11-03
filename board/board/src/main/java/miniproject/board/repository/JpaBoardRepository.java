package miniproject.board.repository;

import miniproject.board.domain.Boards;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaBoardRepository extends JpaRepository<Boards, Integer> { // Boards의 entity 어노테이션을 Integer로 가져옴

// 참고용(for BoardService)
/*    @Override
    default <S extends Boards> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    default <S extends Boards> S save(S entity) {
        return null;
    }

    @Override
    default Optional<Boards> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default void deleteAll() {

    }*/
}  // JpaRepository : 왠만한 CRUD, Pagination, Sorting관련 메서드 제공
