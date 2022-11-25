package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.Record;
import hyu_memento.memento_back.domain.type.GameType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameplayRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(GamePlay gamePlay) {
        em.persist(gamePlay);
        return gamePlay.getSeq();
    }

    public GamePlay findOne(Long seq) {
        return em.find(GamePlay.class, seq);
    }

    public List<GamePlay> findAll(Long member_seq) {
        return em.createQuery("select g from GamePlay g join g.member m where m.member_seq = :member_seq", GamePlay.class)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }

    public List<GamePlay> findByDate(LocalDate date, Long member_seq) {
        return em.createQuery("select g from GamePlay g join g.member m where g.date = :date and m.member_seq = :member_seq", GamePlay.class)
                .setParameter("date", date)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }

    public List<GamePlay> findByType(GameType type, Long member_seq) {
        return em.createQuery("select g from GamePlay g join g.member m where g.type = :type and m.member_seq = :member_seq", GamePlay.class)
                .setParameter("type", type)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }
}
