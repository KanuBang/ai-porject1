package org.example.openai.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;


    public String chat(String message){
        return chatClient.prompt() //프롬프트
                .user(message)// 메시지 전달
                .call()// 호출
                .content(); //// ChatResponse--> 요청정보를 받는 부분(문자열)
    }
}
