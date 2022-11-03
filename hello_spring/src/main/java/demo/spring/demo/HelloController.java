package demo.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


// MVC 템플릿 엔진 예제
// https://dodeon.gitbook.io/study/kimyounghan-spring-introduction/02-spring-basic

@Controller
//@RequestMapping("/hello")
public class HelloController {
    @PostMapping("/hello")
    public String hello(@RequestBody String key1, @RequestBody String key2, @RequestBody String key3, Model model) {
        model.addAttribute("key1", key1);
        model.addAttribute("key2", key2);
        model.addAttribute("key3", key3);
        System.out.println(model);
        return "hello.html";       // hello.html = hello(뒤에 생략)
    }

    @GetMapping("/login")
    @ResponseBody   //  loing으로 객체값을 넣어서 던지면 내가 클라이언트로 제이슨을 던져줄게
    public User login(@RequestParam String id, Model model) {
        model.addAttribute("id", id);
        User user = new User();
        user.setId(id);
        user.setName("hongkildong");
        //model.addAttribute("password", "1234");
        System.out.println(model);
        return user;
    }

    @PostMapping("/login/process")
    public String loginprocess(@RequestBody User user, Model model) {
        System.out.println(user.getId());
        System.out.println(user.getName());

        return "redirect:/";        // 홈으로 일시저으로 리다이렉트(포스트로 나에게 접속했지만 화면은 홈화면으로 우회접속 하도록 함)
    }                               // 여기선 temporary(일시적으로) 리다이렉트 하도록 설정했음
}


/*
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("key1", "hello");
        model.addAttribute("key2", "hello");
        model.addAttribute("key3", "hello");
        System.out.println(model);
        return "hello.html";
    }        // void이면 리턴값이 없음 -> 브라우저 주소창에 http://localhost:8080/hello 찍으면 인텔리제이 콘솔창에 model attribute 출력

    @RequestMapping("/login")
    public void login(Model model) {
        model.addAttribute("id", "aaa");
        model.addAttribute("password", "1234");
        System.out.println(model);
    }       // 브라우저 주소창에 http://localhost:8080/login 찍으면 인텔리제이 콘솔창에 model attribute 출력
}           // 항상 출력전에 rerun 혹은, 데브툴 설치시 약 5~10초 정도의 딜레이를 감내하는 습관까지!!*/
// 여기까지 위에 실습 하기전에 했던 내용 복붙





/*    @Controller
    public class HelloController {
        @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
            model.addAttribute("name", name);       // 기본값은 true(생략)  <- (value = "name" ,required = false)
            return "hello";
        }
    }*/
// localhost:8080hello-mvc?name=data   => required = false로 하면 localhost:8080hello-mvc에서도 에러가 뜨지 않는다.
