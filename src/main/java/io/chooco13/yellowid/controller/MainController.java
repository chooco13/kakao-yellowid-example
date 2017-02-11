package io.chooco13.yellowid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.chooco13.yellowid.module.domain.Keyboard;
import io.chooco13.yellowid.module.domain.Message;
import io.chooco13.yellowid.module.domain.MessageButton;
import io.chooco13.yellowid.module.domain.Photo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    // https://yellowid.kakao.com/bot/api 에서 설정 필요
    // https://github.com/plusfriend/auto_reply 를 참고하여 구현

    // kaffeine 적용을 위해 추가 (https://kaffeine.herokuapp.com/)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void mainPage() {}

    // 최초 채팅방에 들어왔을 때
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

    // 자동 응답 설정 예시
    @ResponseBody
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Map<String, Object> replyMessage(@RequestBody Message req) throws JsonProcessingException {
        Map<String, Object> response = new HashMap<>();

        Message res = new Message();
        res.setType(req.getType());

        if (req.getType().equals("photo")) {
            Photo photo = new Photo();
            photo.setUrl(req.getContent());
            photo.setWidth(640);
            photo.setHeight(480);
            res.setPhoto(photo);
        } else {
            res.setText(req.getContent());

            if (req.getContent().equals("keyboard")) {
                // 상황에 따라 객관식 답변을 위한 키보드를 띄워주고 싶을 경우 예시
                Keyboard keyboard = new Keyboard();
                keyboard.setType("buttons");
                String[] buttons = {"선택 1", "선택 2", "선택 3"};
                keyboard.setButtons(buttons);
                response.put("keyboard", keyboard);
            }

            if (req.getContent().equals("message_button")) {
                // 상황에 따라 메세지 버튼을 띄워주고 싶을 경우 예시
                MessageButton messageButton = new MessageButton();
                messageButton.setLabel("Google");
                messageButton.setUrl("https://www.google.co.kr/");
                res.setMessage_button(messageButton);
            }
        }

        response.put("message", res);

        return response;
    }

    @RequestMapping(value = "/friend", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addFriend(@RequestBody Map<String,String> req) {
        logger.debug("add user_key::" + req.get("user_key"));
    }

    @RequestMapping(value = "/friend/{user_key}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteFriend(@PathVariable String user_key) {
        logger.debug("delete user_key::" + user_key);
    }

    @RequestMapping(value = "/chat_room/{user_key}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void exitChat(@PathVariable String user_key) {
        logger.debug("leave user_key::" + user_key);
    }
}
