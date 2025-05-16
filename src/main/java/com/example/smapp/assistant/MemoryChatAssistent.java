package com.example.smapp.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT, chatModel =  "openAiChatModel", chatMemory = "chatMemory")
public interface MemoryChatAssistent {
    @UserMessage("你是我的好朋友，请用北京话回答问题,并加一些表情符号.{{message}}")
    String chat(@V("message")String message);
}
