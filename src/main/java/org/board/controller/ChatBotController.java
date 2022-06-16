package org.board.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class ChatBotController {

    @RequestMapping(value = "/bot", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String webhook(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        System.out.println(map);
        String value =((Map)map.get("queryResult")).get("queryText").toString();
        System.out.println(value);


        return "";



    }
}
