package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecordRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Record record) {
        em.persist(record);
        return record.getSeq();
    }

    public Record findOne(Long seq) {
        return em.find(Record.class, seq);
    }

    public List<Record> findByDate(LocalDate date, Long member_seq) {
        return em.createQuery("select r from Record r join r.member m where r.date = :date and m.member_seq = :member_seq", Record.class)
                .setParameter("date", date)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }
}
