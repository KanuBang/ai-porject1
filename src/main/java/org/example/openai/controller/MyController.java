package org.example.openai.controller;

import lombok.RequiredArgsConstructor;
import org.example.openai.config.AppConfig;
import org.example.openai.dto.Answer;
import org.example.openai.dto.TeamPlayer;
import org.example.openai.service.ChatService;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public String chatplace(String subject, String tone, String message) {
        return chatService.chatPlace(subject, tone, message);
    }

    @GetMapping("/chatjson") // RuquestParam 자동 바인디. 그러나 비추.
    public ChatResponse chatJson(String message) {
        return chatService.chatJson(message);
    }

    @GetMapping("/chatobject")
    public Answer chatobject(String message) {
        return chatService.chatObject(message);
    }

    @GetMapping("/iconplayer")
    public Answer iconplayer(String country, String number) {
        return chatService.iconPlayer(country, number);
    }

    @GetMapping("/chatlist")
    public List<String> chatlist(String message) {
        return chatService.chatlist(message);
    }

    @GetMapping("/chatmap")
    public Map<String,String> chatmap(String nation) {
        return chatService.chatMap(nation);
    }


    @GetMapping("/chatplayer")
    public List<TeamPlayer> chatTeamPlayer(String position) {
        return chatService.chatPlayer(position);
    }
}
