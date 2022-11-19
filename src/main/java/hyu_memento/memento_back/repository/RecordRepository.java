package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.Record;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RecordRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Record record) {
        em.persist(record);
    }

    public Record findOne(Long seq) {
        return em.find(Record.class, seq);
    }

    public List<Record> findByDate(LocalDate date) {
        return em.createQuery("select r from Record r where r.date = :date", Record.class)
                .setParameter("date", date)
                .getResultList();
    }
}
