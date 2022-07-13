package BoardTests;

import lombok.extern.log4j.Log4j2;
import org.board.domain.BoardVO;
import org.board.dto.ListDTO;
import org.board.mapper.BoardMapper;
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

    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void selectListTest(){
        ListDTO listDTO = new ListDTO();
        listDTO.setType("tcw");
        listDTO.setKeyword("테스트");

        List<BoardVO> dtoList = boardMapper.selectList(listDTO);

        dtoList.forEach((board -> log.info(board)));
    }

    @Test
    public void selectOneTest(){

        int bno = 32760;
        BoardVO boardVO = boardMapper.selectOne(bno);

        log.info(boardVO);
    }

    @Test
    public void registerTest(){

        BoardVO boardVO = BoardVO.builder()
                .title("Test")
                .content("Test1")
                .writer("ChoiGD")
                .build();

        boardMapper.register(boardVO);

    }

    @Test
    public void modifyTest(){
        int bno = 32802;

        BoardVO boardVO = BoardVO.builder()
                .bno(bno)
                .title("수정된 제목입니다")
                .content("수정된 내용입니다")
                .build();

        boardMapper.modify(boardVO);
    }

    @Test
    public void removeTest(){

        int bno =32803;
        boardMapper.remove(bno);
    }

}
