package hyu_memento.memento_back.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuizDto {
    private Long num;
    private String content;
    private String ans;

    @Builder
    public QuizDto(Long num, String content, String ans) {
        this.num = num;
        this.content = content;
        this.ans = ans;
    }
}
