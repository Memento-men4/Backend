package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplianceService {

    private final ApplianceRepository applianceRepository;

    /* 가전 생성 */
    @Transactional
    public Long saveAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    /* 가전 조회 */
    public List<Appliance> findAll(Long member_seq) {
        return applianceRepository.findAll(member_seq);
    }

    /* 가전 날짜별 조회 (추천용) */
    public List<Appliance> findDate(LocalDate date, Long member_seq) {
        return applianceRepository.findByDate(date, member_seq);
    }

}
