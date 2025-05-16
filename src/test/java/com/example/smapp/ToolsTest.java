package com.example.smapp;

import com.example.smapp.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools(){
        String answer2 = separateChatAssistant.chat(4, "475695037565的平方根是多少？");


        System.out.println("平方根结果: " + answer2);
    }
}
