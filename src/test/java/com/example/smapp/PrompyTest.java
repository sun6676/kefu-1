package com.example.smapp;


import com.example.smapp.assistant.MemoryChatAssistent;
import com.example.smapp.assistant.SeparateChatAssistant;
import dev.langchain4j.service.spring.AiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrompyTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testSystemMessage(){
        String answer = separateChatAssistant.chat(3, "今天几号");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistent memoryChatAssistent;
    @Test
    public void testUserMessage(){
        String answer = memoryChatAssistent.chat("我是猪八戒");
        System.out.println(answer);
        String answer1 = memoryChatAssistent.chat("我是22了");
        System.out.println(answer1);
        String answer2 = memoryChatAssistent.chat("你知道我是谁吗,多大了");
        System.out.println(answer2);
    }


    @Test
    public void testV(){
        String answer = separateChatAssistant.chat2(6,"我是猪八戒");
        System.out.println(answer);
        String answer1 = separateChatAssistant.chat2(6,"我是谁");
        System.out.println(answer1);

    }

    @Test
    public void testV3(){
        String answer = separateChatAssistant.chat3(6,"我是怎样成为像孙默一样强大的人","张欣怡",
                23);
        System.out.println(answer);


    }

}
