package org.scoula.controller;
import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

//싱글톤으로 만들어주고, 스프링에 이 클래스가 컨트롤러 역할을 하는 클래스라고 등록시켜줌
@Controller
@Log4j2
public class HomeController {

    //요청 하나당 함수 하나
    //요청이 어떻게 들어오는지 설정
    //어떤 함수를 부를지 정의함

    //스프링에서는 get 요청이 들어오면 어노테이션으로!
    @GetMapping("/") //get요청이 root("/")로 들어오면

    //SampleDTO : 가방역할은 항상 필요할까?
    //HttpSession : 로그아웃전까지, 브라우저를 완전히 다 닫기 전까지
    public String home(Model model, HttpSession session, SampleDTO sampleDTO) {

        //Model : 서버에서 forward할 때 request, response 객체가 계속 전달된다.
        //request 객체에 속성으로 지정함, 속성으로 지정한 것이 request 객체와 함께 forward시 전달됨.
        //jsp에서 꺼내서 출력함
        model.addAttribute("name", "홍길동");
        model.addAttribute("age",100);

        //스프링이 핸들러매퍼에 주소와 방식에 따른 어떤 컨트롤러의 메서드를 불러야 할지를 자동으로 등록시켜줌
        System.out.println("HomeController =====");
        log.info("================> HomController /");
        return "index"; // View파일 이름을 프론트 컨트롤러에게 리턴

        //뷰 리졸버가 /WEB-INF/views/index.jsp를 붙여서
        //프론트 컨트롤러가 불러야할 주소와 파일명으로 만들어줌(렌더링)
    }
}