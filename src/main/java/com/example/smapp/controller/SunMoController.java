package com.example.smapp.controller;

import com.example.smapp.assistant.SunMoAgent;
import com.example.smapp.bean.ChatForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Tag(name="圣手孙默")
@RestController
@RequestMapping("/sunmo")
public class SunMoController {

    @Autowired
    private SunMoAgent sunMoAgent;

    @Operation(summary = "对话")
    @PostMapping(value = "/chat",produces = "text/stream;charset=utf-8")
    public Flux<String> chat(@RequestBody ChatForm chatForm){
        return sunMoAgent.chat(chatForm.getMemoryId(),chatForm.getMessage());
    }
}
