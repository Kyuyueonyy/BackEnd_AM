package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor //생성자 주입해달라는 의미
public class BoardController {

    private final BoardService service;

    /* service 불러올 때 생성자 주입 방식*/
/*    public BoardController(BoardService service) {
        this.service = service;
    }*/

    /* 요청 하나 당 함수 하나씩 작성! */
    @GetMapping("/list") //board/list
    public void list(Model model) {
        //db에서 가지고 온 것 있어야함
        //Controller -> Service -> DAO
        log.info("=================> BoardController /list");
        model.addAttribute("list", service.getList());
        //요청한 주소와 views의 호출할 파일명이 같으면 return 안해도 됨(void함수)
    }

    @GetMapping({ "/get", "/update" })
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");
        model.addAttribute("board", service.get(no));
    }

//    @GetMapping("/get") //board/get

    @GetMapping("/create") //board/create(입력 화면 보여달라는 요청)
    public void create() {
        log.info("create");
    }

//    @GetMapping("/update") //board/update(수정하기 전에 검색 먼저 해서 보여달라는 요청)

    @PostMapping("/create") //board/create(입력한 내용 DB처리 해달라는 요청)
    public String create(BoardDTO board) {
        log.info("create: " + board);
        service.create(board);
        return "redirect:/board/list";
    }

//    @PostMapping("/update") //board/update(수정한 내용 DB처리 해달라는 요청)

    @PostMapping("/delete") //board/delete(삭제한 내용 DB처리 해달라는 요청)
    public String delete(@RequestParam("no") Long no) {
        log.info("delete..." + no);
        service.delete(no);
        return "redirect:/board/list";
    }
}
