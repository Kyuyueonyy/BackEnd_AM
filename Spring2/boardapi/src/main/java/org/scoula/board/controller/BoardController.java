package org.scoula.board.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/board")
@RequiredArgsConstructor
@Log4j2
//@Controller
@RestController //views로 넘어가지 않고(forward하지 않고) 모두 data로 응답하겠다는 의미
//@RestContoller = @Controller + @ResponseBody
@Api(tags = "게시글 관리")
public class BoardController {
    private final BoardService service; //service를 생성자 주입 방법으로

    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
    @GetMapping("") //api/board
    //@ResponseBody //컨트롤러에서 views로 넘어가지 않고
    //http의 body에 리턴값을 넣어서 응답해라
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    @ApiOperation(value = "상세정보 얻기", notes = "게시글 상제 정보를 얻는 API")
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

//    @GetMapping("/get")
//    public
    @GetMapping("/get/{no}") // api/board/get/12
    @ApiParam(value = "게시글 ID", required = true, example = "1")
    public BoardDTO get2(@PathVariable Long no){
        return service.get(no);
    }
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로요청이처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된요청입니다."),
            @ApiResponse(code = 500, message = "서버에서오류가발생했습니다.")
    })

    @PostMapping("") // api/board + post
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO dto) {
        //@RequestBody -> 브라우저에서 보낼때도 json으로 보낼 수 있음
        //서버에서 json을 받을 때 사용하는 어노테이션
        return ResponseEntity.ok(service.create(dto));
    }

}
