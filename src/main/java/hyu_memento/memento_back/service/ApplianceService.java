package hyu_memento.memento_back.service;

import hyu_memento.memento_back.controller.dto.ApplianceReturnDto;
import hyu_memento.memento_back.controller.dto.ApplianceSaveDto;
import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.ApplianceOperation;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplianceService {
    public final MemberService memberService;
    private final ApplianceRepository applianceRepository;

    /* 가전 생성 */
    @Transactional
    public Long saveAppliance(ApplianceSaveDto applianceSaveDto) {
        Appliance appliance = Appliance.builder()
                .member(memberService.findOne(applianceSaveDto.getMember_seq()))
                .serialNum(applianceSaveDto.getSerialNum())
                .type(applianceSaveDto.getType())
                .settingTime(applianceSaveDto.getSettingTime())
                .mon(applianceSaveDto.getMon())
                .tue(applianceSaveDto.getTue())
                .wed(applianceSaveDto.getWed())
                .thr(applianceSaveDto.getThr())
                .fri(applianceSaveDto.getFri())
                .sat(applianceSaveDto.getSat())
                .sun(applianceSaveDto.getSun())
                .build();
        return applianceRepository.save(appliance);
    }

    /* 가전 조회 */
    public List<ApplianceReturnDto> findAllApp(Long member_seq) {
        List<Appliance> findAppliances = applianceRepository.findAll(member_seq);
        List<ApplianceReturnDto> returnAppliances = new ArrayList<>();
        for (Appliance appliance : findAppliances) {
            ApplianceReturnDto returnAppliance = ApplianceReturnDto.builder()
                    .appliance_seq(appliance.getSeq())
                    .serialNum(appliance.getSerialNum())
                    .type(appliance.getType())
                    .settingTime(appliance.getSettingTime())
                    .mon(appliance.getMon())
                    .tue(appliance.getTue())
                    .wed(appliance.getWed())
                    .thr(appliance.getThr())
                    .fri(appliance.getFri())
                    .sat(appliance.getSat())
                    .sun(appliance.getSun())
                    .build();
            returnAppliances.add(returnAppliance);
        }
        return returnAppliances;
    }

    /* 가전 날짜별 조회 (추천용) */
    public List<ApplianceReturnDto> findDateApp(LocalDate date, Long member_seq) {
        List<Appliance> findAppliances = applianceRepository.findByDate(date, member_seq);
        List<ApplianceReturnDto> returnAppliances = new ArrayList<>();
        for (Appliance appliance : findAppliances) {
            ApplianceReturnDto returnAppliance = ApplianceReturnDto.builder()
                    .appliance_seq(appliance.getSeq())
                    .serialNum(appliance.getSerialNum())
                    .type(appliance.getType())
                    .settingTime(appliance.getSettingTime())
                    .mon(appliance.getMon())
                    .tue(appliance.getTue())
                    .wed(appliance.getWed())
                    .thr(appliance.getThr())
                    .fri(appliance.getFri())
                    .sat(appliance.getSat())
                    .sun(appliance.getSun())
                    .build();
            returnAppliances.add(returnAppliance);
        }
        return returnAppliances;
    }

    public Appliance findOne(Long seq) { return applianceRepository.findOne(seq);}

}
