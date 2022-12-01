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
    @PostMapping("/quiz_1")
    public NuguReturnDto findQuiz1(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 1L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }

    @PostMapping("/quiz_2")
    public NuguReturnDto findQuiz2(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 2L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }

    @PostMapping("/quiz_3")
    public NuguReturnDto findQuiz3(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 3L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }

    @PostMapping("/quiz_4")
    public NuguReturnDto findQuiz4(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 4L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }

    @PostMapping("/quiz_5")
    public NuguReturnDto findQuiz5(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 5L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }

    @PostMapping("/quiz_6")
    public NuguReturnDto findQuiz6(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 6L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();

        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }

    @PostMapping("/quiz_7")
    public NuguReturnDto findQuiz7(@RequestBody String nugu) {
        JSONObject jsonObj = new JSONObject(nugu);
        String version = (String) jsonObj.get("version");
        JSONObject action = jsonObj.getJSONObject("action");
        JSONObject parameters = action.getJSONObject("parameters");
        JSONObject jmember_seq = parameters.getJSONObject("member_seq");
        JSONObject jdate = parameters.getJSONObject("date");

        LocalDate date = LocalDate.parse((String) jdate.get("value"), DateTimeFormatter.ISO_DATE);
        Long member_seq = Long.valueOf(String.valueOf(jmember_seq.get("value")));

        QuizDto quizContent = quizService.findQuizContent(date, 7L, member_seq);

        NuguOutputDto nuguoutput = NuguOutputDto.builder()
                .quiz_content(quizContent.getContent())
                .date((String) jdate.get("value"))
                .member_seq((String) jmember_seq.get("value"))
                .build();
        
        NuguReturnDto returndto = NuguReturnDto.builder()
                .version(version)
                .resultCode("OK")
                .output(nuguoutput)
                .build();
        return returndto;
    }
}
