package org.example.openai.controller;

import lombok.RequiredArgsConstructor;
import org.example.openai.config.AppConfig;
import org.example.openai.service.ChatService;
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

}
