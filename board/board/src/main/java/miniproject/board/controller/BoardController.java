package miniproject.board.controller;

import miniproject.board.domain.Boards;
import miniproject.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/boardlist")               // "/"으로 들어오면 매핑되서 화면에 띄워주게 만드는 어노테이션
    public String boardlist(Model model){
        List<Boards> boards = service.boardsList();
        model.addAttribute("boards", boards);
        return "boardlist.html";               // .html 생략가능
    }// 홈에 접속하면 boardlist.html가 뜨게

    @GetMapping("/board/{id}")
    public String board(Model model, @PathVariable("id") Integer id){
        Boards board = service.boards(id);
        model.addAttribute("board", board);
        return "board";
    }

    @GetMapping("/boardwrite")
    public String boardwrite(){
        return "boardwrite";
    }

    @PostMapping("/boardwrite")
    public String boardwritepost(BoardForm form) {
        Boards board = new Boards();
        board.setId(form.getId());
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        // service 로직을 만들고, repository를 통해 db에 저장(추가) (id 없을 때는 insert가 자동 생성)
        // Integer id = service.boardSave(boards);
        service.boardSave(board);
        //System.out.println(boards.getTitle()+":" + boards.getContent());
        return "redirect:/boardlist";
    }
    
    @PostMapping("/boardUpdate")
    public String boardUpdate(BoardForm form){    // 폼과 path의 변수 둘 다 가져오도록 설정
        System.out.println(form);
        // service 로직, repository db에 추가 (id 없을 때는 insert가 자동 생성, id가 있으면 update)
        Boards board = service.boards(form.getId());
        if(form.getTitle() != board.getTitle()){        // 업데이트가 일어났을 때만 변경해 주는 것
            board.setTitle(form.getTitle());
        }
        if(form.getContent() != board.getContent()){
            board.setContent(form.getContent());
        }
        service.boardSave(board);
        return "redirect:/boardlist";
    }

    @PostMapping("/boardDelete")
    public String boardDelete(Integer id) {
        service.boardDelete(id);
        return "redirect:/boardlist";
    }
}
