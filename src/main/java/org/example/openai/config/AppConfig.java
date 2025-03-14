package org.example.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

    @Value("classpath:/prompt.txt")
    private Resource resource;


    // chatClient<----apikey----->llm
    // 자동으로 chatClientBuilder에 apikey가 자동으로 들어간다
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {

        // 0.default
        return chatClientBuilder.build();

        // 1. LLM에 역할을 부여
        //return chatClientBuilder.defaultSystem("당신은 교육 튜터입니다. 개념을 이해하기 쉽게 설명하고 예시를 제공하세요.").build();

        // 2. txt에 paramter로 llm 역할 부여하기
        //return chatClientBuilder.defaultSystem(resource).build();
    }
}
