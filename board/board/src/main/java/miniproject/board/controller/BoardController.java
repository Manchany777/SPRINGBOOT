package miniproject.board.controller;

import miniproject.board.domain.Boards;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping("/boardlist")               // "/"으로 들어오면 매핑되서 화면에 띄워주게 만드는 어노테이션
    public String boardlist(){
       return "boardlist.html";      // .html 생략가능
    }// 홈에 접속하면 boardlist.html가 뜨게

    @GetMapping("/board")
    public String board(){
        return "board";
    }

    @GetMapping("/boardwrite")
    public String boardwrite(){
        return "boardwrite";
    }

    @PostMapping("/boardwrite")
    public String boardwritepost(Boards boards) {
        // service 로직을 만들고, repository를 통해 db에 저장
        System.out.println(boards.getTitle()+":" + boards.getContent());
        return "redirect:/boardlist";
    }
}
