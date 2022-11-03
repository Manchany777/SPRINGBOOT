package miniproject.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBoardRepository extends JpaRepository {     // JpaRepository : 왠만한 CRUD, Pagination, Sorting관련 메서드 제공
}
