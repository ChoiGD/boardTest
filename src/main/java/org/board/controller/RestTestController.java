package org.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/")
@Log4j2
public class RestTestController {

    @GetMapping("/test")
    public String[] RestTest(){
        return new String[]{"AAA","BBB","CCC","DDD"};
    }


    @GetMapping("/test/{bno}")
    public String[] RestTest2(@PathVariable("bno") Integer bno, @RequestParam Map<String,Object> map){
        log.info("------------------------------------------");
        log.info(bno);
        log.info(map.get("name"));
        log.info(map.get("age"));

        return new String[]{(String)map.get("name"), (String)map.get("age")};
    }

}
