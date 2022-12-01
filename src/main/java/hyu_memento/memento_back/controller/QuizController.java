package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.QuizDto;
import hyu_memento.memento_back.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class QuizController {
    public final QuizService quizService;

    /* 퀴즈 생성 */
    @PostMapping("/quiz")
    public Long save(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        return quizService.createQuiz(date, member_seq);
    }

    /* 퀴즈 조회 */
    @GetMapping("/quiz")
    public String findQuiz(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long seq, @RequestParam Long member_seq) {
        // TODO : nugu에 맞게 parameter 받아오기
        QuizDto quizContent = quizService.findQuizContent(date, seq, member_seq);
        return quizContent.getContent();
    }
}
