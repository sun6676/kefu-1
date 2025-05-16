package com.example.smapp.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;


@AiService(wiringMode = EXPLICIT, streamingChatModel ="openAiStreamingChatModel",
        chatMemoryProvider = "chatMemoryProviderSunMo",contentRetriever = "contentRetrieverSunMoPincone")
public interface SunMoAgent {

    @SystemMessage(fromResource = "sunmo-prompt-word.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
