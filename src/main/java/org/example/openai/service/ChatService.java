package org.example.openai.service;

import lombok.RequiredArgsConstructor;
import org.example.openai.dto.Answer;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
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

    public String chatMessage(String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();
    }

    public String chatPlace(String subject, String tone, String message){
        return chatClient.prompt()
                .user(message)
                .system(sp -> sp.param("subject", subject).param("tone",tone))
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();
    }

    public ChatResponse chatJson(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .chatResponse(); // json
    }

    public Answer chatObject(String message) {
        return chatClient.prompt().user(message).call().entity(Answer.class);
    }

    private final String iconPlayerTemplate = "Answer for who is best player in {country}? " +
            "Tell me {number} players"
            +"you dont have to send me result as a list. just give me text";
    public Answer iconPlayer(String country, String number){
        return chatClient.prompt().user(userSpec -> userSpec.text(iconPlayerTemplate)
                .param("country", country)
                .param("number", number))
                .call()
                .entity(Answer.class);
    }
}
