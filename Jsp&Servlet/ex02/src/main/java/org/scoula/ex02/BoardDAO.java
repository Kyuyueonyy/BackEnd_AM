package org.scoula.ex02;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    public List<BoardVO> getList(){
        List<BoardVO> list = new ArrayList<BoardVO>();
        for (int i = 0; i < 100; i++) {
            BoardVO vo = new BoardVO(i,
                    "title" + i,
                    "content" + i,
                    "writer" + i);
            list.add(vo);
        }
        return list;
    }
}

