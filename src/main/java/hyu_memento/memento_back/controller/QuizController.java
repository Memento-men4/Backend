package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.QuizDto;
import hyu_memento.memento_back.controller.nugu_dto.NuguOutputDto;
import hyu_memento.memento_back.controller.nugu_dto.NuguReturnDto;
import hyu_memento.memento_back.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    @PostMapping("/quiz/nugu")
    public NuguReturnDto findQuiz(@RequestBody String nugu) {
        // TODO : nugu에 맞게 parameter 받아오기
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject seq = parameters.getJSONObject("seq");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long quiz_seq = Long.valueOf(String.valueOf(seq.get("value")));
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, quiz_seq, member_seq);

        // TODO : nugu에 맞게 parameter 반환하기
        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }
}
