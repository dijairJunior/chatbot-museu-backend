package com.rocketsys.chatbotmuseu.ultils;

import com.rocketsys.chatbotmuseu.domain.FaqAnswer;
import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FaqAnswers {
    private ArrayList<FaqAnswer> answers;
    private String defaultAnswers;

    public FaqAnswers() {
        try {
            JSONTokener tokener = new JSONTokener(new FileInputStream("src/main/resources/static/answers.json"));
            JSONObject faqData = new JSONObject(tokener);
            JSONArray faqArray = faqData.getJSONArray("faq");
            this.answers = new ArrayList<>();

            for (int i = 0; i < faqArray.length(); i++) {
                JSONObject faqAnswer = faqArray.getJSONObject(i);
                JSONArray keywordsArray = faqAnswer.getJSONArray("keywords");
                List<String> keywords = new ArrayList<>();
                for (int j = 0; j < keywordsArray.length(); j++) {
                    keywords.add(keywordsArray.getString(j));
                }
                String answer = faqAnswer.getString("answer");
                this.answers.add(new FaqAnswer(keywords, answer));
            }

            this.defaultAnswers = faqData.getString("default");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

