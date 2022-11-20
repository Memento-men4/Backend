package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplianceService {

    private final ApplianceRepository applianceRepository;

    /* 가전 생성 */
    @Transactional
    public Long createAppliance(Appliance appliance) {
        applianceRepository.save(appliance);
        return appliance.getSeq();
    }

    /* 가전 조회 */
    public List<Appliance> findAll(Member member) {
        return applianceRepository.findAll(member.getMember_seq());
    }

}
