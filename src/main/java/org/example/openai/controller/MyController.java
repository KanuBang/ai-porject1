package org.example.openai.controller;

import lombok.RequiredArgsConstructor;
import org.example.openai.config.AppConfig;
import org.example.openai.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final ChatService chatService;


    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
        return chatService.chat(message);
    }

    @GetMapping("/chatmessage")
    public String chatMessage(@RequestParam("message") String message) {
        return chatService.chatMessage(message);
    }

    @GetMapping("/chatplace")
    public String chatplace(String subject, String tone, String message){
        return chatService.chatPlace(subject,tone,message);
    }

    @GetMapping("/chatjson") // RuquestParam 자동 바인디. 그러나 비추.
    public ChatResponse chatJson(String message){
        return chatService.chatJson(message);
    }
}
