package hyu_memento.memento_back.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hyu_memento.memento_back.controller.dto.FlaskResponseDto;
import hyu_memento.memento_back.controller.dto.QuizDto;
import hyu_memento.memento_back.domain.Quiz;
import hyu_memento.memento_back.domain.QuizContent;
import hyu_memento.memento_back.domain.Record;
import hyu_memento.memento_back.repository.MemberRepository;
import hyu_memento.memento_back.repository.QuizRepository;
import hyu_memento.memento_back.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuizService {
    private final MemberRepository memberRepository;
    private final QuizRepository quizRepository;
    private final RecordRepository recordRepository;

    private final String url = "http://3.35.96.4:5000/ai";
    public FlaskResponseDto requestToFlask(List<String> texts) {
        RestTemplate restTemplate = new RestTemplate();

        // Header set
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        // Body set
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("text1", texts.get(0));
        body.add("text2", texts.get(1));
        body.add("text3", texts.get(2));
        body.add("text4", texts.get(3));
        body.add("text5", texts.get(4));
        body.add("text6", texts.get(5));
        body.add("text7", texts.get(6));


        // Message
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        // Request
        HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);

        // Response 파싱
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        FlaskResponseDto dto = new FlaskResponseDto();
        try {
            dto = objectMapper.readValue(response.getBody(), FlaskResponseDto.class);
        } catch (Exception e) {

        }

        return dto;
    }

    /* 퀴즈 생성 */
    @Transactional
    public Long createQuiz(LocalDate date, Long member_seq) {
        Quiz quiz = new Quiz(memberRepository.findOne(member_seq), date);
        List<Record> byDate = recordRepository.findByDate(date, member_seq);
        List<String> texts = new ArrayList<>();
        for (Record record : byDate) {
            String content = record.getContent();
            texts.add(content);
        }
        FlaskResponseDto flaskResponseDto = requestToFlask(texts);

        QuizContent qc1 = QuizContent.builder()
                .num(1L)
                .content(flaskResponseDto.getText1())
                .build();
        quiz.addQuizContent(qc1);

        QuizContent qc2 = QuizContent.builder()
                .num(2L)
                .content(flaskResponseDto.getText2())
                .build();
        quiz.addQuizContent(qc2);

        QuizContent qc3 = QuizContent.builder()
                .num(3L)
                .content(flaskResponseDto.getText3())
                .build();
        quiz.addQuizContent(qc3);

        QuizContent qc4 = QuizContent.builder()
                .num(4L)
                .content(flaskResponseDto.getText4())
                .build();
        quiz.addQuizContent(qc4);

        QuizContent qc5 = QuizContent.builder()
                .num(5L)
                .content(flaskResponseDto.getText5())
                .build();
        quiz.addQuizContent(qc5);

        QuizContent qc6 = QuizContent.builder()
                .num(6L)
                .content(flaskResponseDto.getText6())
                .build();
        quiz.addQuizContent(qc6);

        QuizContent qc7 = QuizContent.builder()
                .num(7L)
                .content(flaskResponseDto.getText7())
                .build();
        quiz.addQuizContent(qc7);

        return quizRepository.save(quiz);
    }

    /* 퀴즈 조회*/
    public QuizDto findQuizContent(LocalDate date, Long seq, Long member_seq) {
        QuizContent quizCon = quizRepository.findQuizCon(date, seq, member_seq);
        QuizDto quizdto = QuizDto.builder()
                .num(quizCon.getNum())
                .content(quizCon.getContent())
                .build();
        return quizdto;
    }
}
