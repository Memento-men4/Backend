package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuizRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Quiz quiz) {
        em.persist(quiz);
    }

    public Quiz findOne(Long seq) {
        return em.find(Quiz.class, seq);
    }

    public List<Quiz> findAll(Long member_seq) {
        return em.createQuery("select q from Quiz q join q.member m where m.member_seq = :member_seq", Quiz.class)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }

    public Quiz findByDate(LocalDate date, Long member_seq) {
        return em.createQuery("select q from Quiz q join q.member m where q.date = :date and m.member_seq = :member_seq", Quiz.class)
                .setParameter("date", date)
                .setParameter("member_seq", member_seq)
                .getSingleResult();
    }
}
