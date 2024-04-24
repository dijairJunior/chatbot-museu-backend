package com.rocketsys.chatbotmuseu.services;

import com.rocketsys.chatbotmuseu.ultils.FaqAnswers;
import com.rocketsys.chatbotmuseu.domain.FaqAnswer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FaqService {

    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question) {
        String[] words = question.toLowerCase().split("\\s+");
        List wordsList = Arrays.asList(words).stream().map(String::toLowerCase).toList();
        System.out.println(wordsList);

        for (FaqAnswer entry : faqAnswers.getAnswers()) {
            for (String keyword : entry.getKeywords()) {
                if (wordsList.contains(keyword.toLowerCase())) {
                    return entry.getAnswer();
                }
            }
        }

        return faqAnswers.getDefaultAnswers();
    }
}
