package mapper;

import lombok.extern.log4j.Log4j2;
import org.board.mapper.TimeMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")

public class TimeMapperTests {

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Test
    public void Test1(){
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

    @Test
    public void Test2(){
        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}
