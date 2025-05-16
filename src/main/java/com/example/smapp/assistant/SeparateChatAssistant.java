package com.example.smapp.assistant;


import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT, chatModel =  "qwenChatModel",
        chatMemoryProvider = "chatMemoryProvider",tools="calculatorTools")
public interface SeparateChatAssistant {
//    @SystemMessage("你是我的好朋友，请用东北话回答问题.今天是{{current_date}}")
    @SystemMessage(fromResource = "my-prompt-word.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    @UserMessage("你是我的好朋友，请用北京话回答问题,并加一些表情符号.{{message}}")
    String chat2(@MemoryId int memoryId, @V("message") String userMessage);

    @SystemMessage(fromResource = "my-prompt-word3.txt")
    String chat3(@MemoryId int memoryId,
                 @UserMessage String userMessage,
                 @V("username") String username,
                 @V("age") int age);
}
