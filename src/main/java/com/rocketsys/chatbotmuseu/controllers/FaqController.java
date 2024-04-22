package com.rocketsys.chatbotmuseu.controllers;

import com.rocketsys.chatbotmuseu.dto.MessageRequest;
import com.rocketsys.chatbotmuseu.ultils.FaqAnswers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {

    @PostMapping
    public ResponseEntity<String> answerQuestion(@RequestBody MessageRequest request){
        FaqAnswers faqAnswers = new FaqAnswers();
        System.out.println(faqAnswers.getAnswers().get(0).getAnswer());
        return ResponseEntity.ok("Ok deu certo!");
    }
}
