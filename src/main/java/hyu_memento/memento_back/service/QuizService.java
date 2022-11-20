package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.Quiz;
import hyu_memento.memento_back.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    /* 퀴즈 생성 */
    @Transactional
    public Long createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
        return quiz.getSeq();
    }

    /* seq(PK)로 조회 */
    public Quiz findOne(Long seq) {
        return quizRepository.findOne(seq);
    }

    /* (개인별) 모든 퀴즈 조회 */
    public List<Quiz> findAllQuiz(Member member) {
        return quizRepository.findAll(member.getMember_seq());
    }

    /* (개인별) 날짜별 퀴즈 조회 */
    public Quiz findDayQuiz(LocalDate date, Member member) {
        return quizRepository.findByDate(date, member.getMember_seq());
    }
}
