package com.rocketsys.chatbotmuseu.controllers;

import com.rocketsys.chatbotmuseu.dto.MessageRequest;
import com.rocketsys.chatbotmuseu.dto.MessageResponse;
import com.rocketsys.chatbotmuseu.services.FaqService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class FaqController {

    private FaqService faqService;

    private FaqController(FaqService faqService){
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> answerQuestion(@RequestBody MessageRequest request){
        String answer = this.faqService.getAnswer(request.message());
        MessageResponse response = new MessageResponse(answer);
        return ResponseEntity.ok(response);
    }
}
