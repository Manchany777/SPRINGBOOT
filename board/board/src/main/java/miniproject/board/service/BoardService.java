package miniproject.board.service;

import miniproject.board.domain.Boards;
import miniproject.board.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private final JpaBoardRepository repository;

    public BoardService(JpaBoardRepository repository) {
        this.repository = repository;
    }

    public void boardSave(Boards boards){
        repository.save(boards);                   // <==>  Boards boards = repository.save(boards);
        //return repository.save(boards).getId();    // <==>  return board.getId();
    }

    public List<Boards> boardsList() {
        List<Boards> boards = repository.findAll();
        return boards;
    }

    public void boardDelete(Integer id) {
        repository.deleteById(id);
    }

    public Boards boards(Integer id) {   // Optional ==> 리스트 [ {board} ]  --> board에서 get을 꺼내주세요
        Optional<Boards> boardsList = repository.findById(id);
        return boardsList.get();
    }
}
