package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.QuizDto;
import hyu_memento.memento_back.service.QuizService;
import lombok.RequiredArgsConstructor;
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
    public Long save() {
        LocalDate date = LocalDate.now();
        return quizService.createQuiz(date);
    }

    /* 퀴즈 조회 */
    @GetMapping("/quiz")
    public String findQuiz(@RequestParam Long seq) {
        LocalDate date = LocalDate.now();
        QuizDto quizContent = quizService.findQuizContent(date, seq);
        return quizContent.getContent();
    }
}
