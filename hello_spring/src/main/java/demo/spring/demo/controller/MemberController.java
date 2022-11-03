package demo.spring.demo.controller;

import demo.spring.demo.domain.Member;
import demo.spring.demo.domain.MemberForm;
import demo.spring.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private MemberService service;

    // @Autowired ==> 1) 필드 2) 생성자 (0) (-> 가장 좋은 방법) 3) 셋터 메소드(가장 좋지 않은 방법)
    @Autowired
    public MemberController(MemberService service){
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "home";             // 끝에 .html 안찍어줘도 인식됨
    }

    @GetMapping("/members/new")
    public String join(MemberForm form) {
        return "membersnew"; // 이름 입력받는 화면을 뿌려준다
    }

    @PostMapping("/members/new")
    public String joinprocess(Member member){ // 입력받은 이름을 db에 추가해준다
       /* Member member = new Member();
        member.setName(form.getName());
        member.setPhone(form.getPhone());
        member.setEmail(form.getEmail());
        member.setAddress(form.getAddress());
        System.out.println(form.getName()+ form.getPhone()  + form.getAddress() + form.getEmail());*/
        service.memberJoin(member);
        return "redirect:/";
    }


    @GetMapping("/memberlist")
    public String memberList(Model model){ // db에 있는 회원정보를 화면에 뿌려준다
    List<Member> members = service.findAllMembers();  // service의 findAllMembers를 members에 가져와서 List로 뿌린것
    model.addAttribute("members", members);  // model에다 memberlist를 더해서 view리졸버에서 화면에 타임리프 양식으로 뿌려줌
    return "memberlist";
    }

    @GetMapping("/member/{id}")
    public String member(Model model, @PathVariable("id") Long id) {
        Member member = service.findMember(id).get();
        model.addAttribute("member", member);
        return "member";
    }

/*    @PostMapping("/member/{id}")
    public String memberUpdate(Model model, @PathVariable("id") Long id) {
        Member member = service.findMember(id).get();
        model.addAttribute("member", member);
        return "redirect:/";
    }*/
}