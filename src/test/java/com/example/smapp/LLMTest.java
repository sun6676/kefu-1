package com.example.smapp;


import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {
    @Test
    public void testGPTDemo(){

        OpenAiChatModel model= OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("hello");
        System.out.println(answer);

    }

    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void testSpringBoot(){
        String answer = openAiChatModel.chat("我是谁");
        System.out.println(answer);
    }
    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOlllma(){
        String answer = ollamaChatModel.chat("我是谁");
        System.out.println(answer);
    }
    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void testQwen(){
        String answer = qwenChatModel.chat("我是谁");
        System.out.println(answer);
    }

}
