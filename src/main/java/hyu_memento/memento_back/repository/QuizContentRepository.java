package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.Quiz;
import hyu_memento.memento_back.domain.QuizContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizContentRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(QuizContent quizContent) {
        em.persist(quizContent);
        return quizContent.getSeq();
    }

    public List<QuizContent> findAllContents(Long quiz_seq) {
        return em.createQuery("select c from QuizContent c join c.quiz q where q.seq = :quiz_seq", QuizContent.class)
                .setParameter("quiz_seq", quiz_seq)
                .getResultList();
    }
}
