package BoardTests;

import lombok.extern.log4j.Log4j2;
import org.board.dto.BoardDTO;
import org.board.service.BoardService;
import org.board.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardTests {

    @Autowired
    private BoardServiceImpl boardService;

    @Test
    public void selectListTest(){

        List<BoardDTO> dtoList = boardService.selectList();

        log.info(dtoList);
    }

    @Test
    public void selectOneTest(){

        int bno = 32760;
        BoardDTO boardDTO = boardService.selectOne(bno);

        log.info(boardDTO);
    }



}
