package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FaqAnswer {
    private List<String> answers;
    private String answer;
}
