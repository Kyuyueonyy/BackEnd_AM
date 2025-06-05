package org.scoula.ex02.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    public abstract String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    //인터페이스를 부품(객체로 생성)으로 사용 불가능
    //인터페이스를 클래스로 구현한 다음 객쳋로 생성할 수 있음.
    //create요청 들어오면 execute() 안에 해당 해시테이블에서 찾은
    //컴트롤러의 메서드를 호출하도록  추강메서드를 구현한 클래스를 만들어 사용함.
//    new Command({
//        execute(req, resp){
//            return memberController.create(); //Viewname으르 리턴
//        }
//    })//인터페이스를 구현한 익명클래스가 됨
}
