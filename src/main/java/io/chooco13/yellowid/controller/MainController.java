package io.chooco13.yellowid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.chooco13.yellowid.module.domain.Keyboard;
import io.chooco13.yellowid.module.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    // https://yellowid.kakao.com/bot/api 에서 설정 필요
    // https://github.com/plusfriend/auto_reply 를 참고하여 구현

    @ResponseBody
    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public Keyboard keyboardInitializing() {
        Keyboard keyboard = new Keyboard();

        // 주관식 답변을 원할 경우
        keyboard.setType("text");

        // 객관식 답변을 원할 경우
        // keyboard.setType("buttons");
        // String[] buttons = {"선택 1", "선택 2", "선택 3"};
        // keyboard.setButtons(buttons);

        return keyboard;
    }

    @ResponseBody
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Map<String, Object> replyMessage(@RequestBody Message res) throws JsonProcessingException {
        logger.debug(new ObjectMapper().writeValueAsString(res));

        Message req = new Message();
        req.setText("pong");

        Map<String, Object> response = new HashMap<>();
        response.put("message", req);

        return response;
    }

    @RequestMapping(value = "/friend", method = RequestMethod.POST)
    public void addFriend(@RequestBody String user_key) {
        logger.debug("add user_key::" + user_key);
    }

    @ResponseBody
    @RequestMapping(value = "/friend/{user_key}", method = RequestMethod.DELETE)
    public String deleteFriend(@PathVariable String user_key) {
        logger.debug("delete user_key::" + user_key);

        return user_key;
    }

    @ResponseBody
    @RequestMapping(value = "/chat_room/{user_key}", method = RequestMethod.DELETE)
    public String exitChat(@PathVariable String user_key) {
        logger.debug("leave user_key::" + user_key);

        return user_key;
    }
}
