package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.ApplianceOperation;
import hyu_memento.memento_back.domain.GamePlay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplianceRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Appliance appliance) {
        // item은 JPA에 저장하기 전까지 seq값이 없다
        if (appliance.getSeq() == null) {
            // seq값이 없다 : 완전히 새로 생성한 객체 라는 뜻 !
            em.persist(appliance);
        } else {
            // seq값이 있다 : 이미 db에 저장되어 있다는 뜻 ! -> 수정할 목적으로 불러온 거
            em.merge(appliance); // 업데이트 비슷한거
        }
        return appliance.getSeq();
    }

    public List<Appliance> findAll(Long member_seq) {
        return em.createQuery("select a from Appliance a join a.member m where m.member_seq = :member_seq", Appliance.class)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }

    public List<Appliance> findByDate(LocalDate date, Long member_seq) {
        int dayOfWeekNumber = date.getDayOfWeek().getValue();

        if (dayOfWeekNumber == 1) {
            return em.createQuery("select a from Appliance a join a.member m where a.mon = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        } else if (dayOfWeekNumber == 2) {
            return em.createQuery("select a from Appliance a join a.member m where a.tue = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        } else if (dayOfWeekNumber == 3) {
            return em.createQuery("select a from Appliance a join a.member m where a.wed = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        } else if (dayOfWeekNumber == 4) {
            return em.createQuery("select a from Appliance a join a.member m where a.thr = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        } else if (dayOfWeekNumber == 5) {
            return em.createQuery("select a from Appliance a join a.member m where a.fri = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        } else if (dayOfWeekNumber==6) {
            return em.createQuery("select a from Appliance a join a.member m where a.sat = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        } else if (dayOfWeekNumber==7) {
            return em.createQuery("select a from Appliance a join a.member m where a.sun = TRUE and m.member_seq = :member_seq", Appliance.class)
                    .setParameter("member_seq", member_seq)
                    .getResultList();
        }
        return null;
    }

    public Appliance findOne(Long seq) {
        return em.find(Appliance.class, seq);
    }
}
