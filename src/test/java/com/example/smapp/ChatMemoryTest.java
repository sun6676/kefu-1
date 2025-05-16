package com.example.smapp;

import com.example.smapp.assistant.MemoryChatAssistent;
import com.example.smapp.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private MemoryChatAssistent memoryChatAssistent;
    @Test
    public void testChatMemory(){
        String answer1 = memoryChatAssistent.chat("我是猪");
        System.out.println(answer1);
        String answer2 = memoryChatAssistent.chat("我是谁");
        System.out.println(answer2);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory2(){
        String answer1 = separateChatAssistant.chat(1,"我是猪");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(2,"我是谁");
        System.out.println(answer2);
    }
}
