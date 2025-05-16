package com.example.smapp.assistant;


import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(wiringMode = EXPLICIT,chatModel = "qwenChatModel")
public interface Assistant {
    String chat(String UserMessage);
}
