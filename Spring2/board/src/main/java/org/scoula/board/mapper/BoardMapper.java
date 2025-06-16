package org.scoula.board.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.scoula.board.domain.BoardVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository //저장(DB)
//@Component + DB 예외처리 기능을 합친 것
@Mapper
public interface BoardMapper {
    //@Select("select * from tbl_board order by no desc")
    public List<BoardVO> getList();

    //상세 검색
    public BoardVO get(Long no);


    public void create(BoardVO board);
}