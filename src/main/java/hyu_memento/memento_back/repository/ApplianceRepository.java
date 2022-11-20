package hyu_memento.memento_back.repository;

import hyu_memento.memento_back.domain.Appliance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplianceRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Appliance appliance) {
        // item은 JPA에 저장하기 전까지 seq값이 없다
        if (appliance.getSeq() == null) {
            // seq값이 없다 : 완전히 새로 생성한 객체 라는 뜻 !
            em.persist(appliance);
        } else {
            // seq값이 있다 : 이미 db에 저장되어 있다는 뜻 ! -> 수정할 목적으로 불러온 거
            em.merge(appliance); // 업데이트 비슷한거
        }
    }

    public List<Appliance> findAll(Long member_seq) {
        return em.createQuery("select a from Appliance a join a.member m where m.member_seq = :member_seq", Appliance.class)
                .setParameter("member_seq", member_seq)
                .getResultList();
    }


}
