package com.monet.chat.messages.messageschat.Controller;

import com.monet.chat.messages.messageschat.Enum.MessageType;
import com.monet.chat.messages.messageschat.Model.ChatMessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class MessageController {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessageModel chatRegister(@Payload ChatMessageModel chatMessageModel,
                                         SimpMessageHeaderAccessor simpMessageHeaderAccessor){
        simpMessageHeaderAccessor.getSessionAttributes().put("user", chatMessageModel.getSender());
        chatMessageModel.setContent("has Joined!");
        return chatMessageModel;
    }


    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessageModel chatMessageSend(@Payload ChatMessageModel chatMessageModel){
        return chatMessageModel;
    }

}
