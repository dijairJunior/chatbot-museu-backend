package com.rocketsys.chatbotmuseu.controllers;

import com.rocketsys.chatbotmuseu.dto.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {

    @PostMapping
    public ResponseEntity<String> answerQuestion(@RequestBody MessageRequest request){
        System.out.println(request.message());
        return ResponseEntity.ok("Ok deu certo!");
    }
}
