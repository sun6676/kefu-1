package com.example.smapp;

import com.example.smapp.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AIServiceTest {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testChat(){
        Assistant assistant= AiServices.create(Assistant.class,openAiChatModel);
        String answer = assistant.chat("你好");
        System.out.println(answer);
    }

    @Autowired
    private Assistant assistant;
    @Test
    public void testAssistant(){
        String answer = assistant.chat("你是谁");
        System.out.println(answer);

    }
}
