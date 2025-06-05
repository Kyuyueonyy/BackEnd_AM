package org.scoula.ex02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController {
    //요청 하나당 함수 하나
    // '/'(루트)로 요청 들어왔을 때(첫 페이지) 호출할 함수를 정의함
    //도메인별 컨트롤러의 메서드의 리턴은 결과를 담을 view파일이름이 되어야함.
    public String getIndex(HttpServletRequest req,
                           HttpServletResponse resp) throws IOException {
        //함수별 처리 내용을 여기에 씀
        return "index";
    }
}



