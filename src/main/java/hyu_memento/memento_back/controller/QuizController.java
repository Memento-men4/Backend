package hyu_memento.memento_back.controller;

import com.mysql.cj.xdevapi.JsonParser;
import hyu_memento.memento_back.controller.dto.QuizDto;
import hyu_memento.memento_back.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class QuizController {
    public final QuizService quizService;

    /* 퀴즈 생성 */
    @PostMapping("/quiz")
    public Long save(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        return quizService.createQuiz(date, member_seq);
    }

    //@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long seq, @RequestParam Long member_seq
    /* 퀴즈 조회 */
    @PostMapping("/quiz/nugu")
    public String findQuiz(@RequestBody String nugu) {
        // TODO : nugu에 맞게 parameter 받아오기
        JSONObject jsonObj = new JSONObject(nugu);
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        System.out.println(parameters.get("seq"));
        System.out.println(parameters.get("member_seq"));
        System.out.println(parameters.get("date"));
//        QuizDto quizContent = quizService.findQuizContent(date, seq, member_seq);
//        return quizContent.getContent();
    }
}
