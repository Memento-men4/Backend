package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.ApplianceOperation;
import hyu_memento.memento_back.domain.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplianceOperationRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(ApplianceOperation op) {
        em.persist(op);
        return op.getSeq();
    }

    public ApplianceOperation findOne(Long seq) {
        return em.find(ApplianceOperation.class, seq);
    }

    public List<ApplianceOperation> findAll(Long member_seq) {
        return em.createQuery("select o from ApplianceOperation o join o.member m where m.member_seq = :member_seq", ApplianceOperation.class)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }

    public List<ApplianceOperation> findByDate(LocalDate date, Long member_seq) {
        return em.createQuery("select o from ApplianceOperation o join o.member m where o.date = :date and m.member_seq = :member_seq", ApplianceOperation.class)
                .setParameter("date", date)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }
}