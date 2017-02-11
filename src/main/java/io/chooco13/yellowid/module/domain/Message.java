package io.chooco13.yellowid.module.domain;

import lombok.Data;


@Data
public class Message {
    private String text;
    private String user_key;
    private String type;
    private String content;
    private Photo photo;
    private MessageButton message_button;
}
