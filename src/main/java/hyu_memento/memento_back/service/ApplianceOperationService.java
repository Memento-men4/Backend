package hyu_memento.memento_back.service;

import hyu_memento.memento_back.controller.dto.ApplianceopReturnDto;
import hyu_memento.memento_back.controller.dto.ApplianceopSaveDto;
import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.ApplianceOperation;
import hyu_memento.memento_back.repository.ApplianceOperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplianceOperationService {
    public final MemberService memberService;
    private final ApplianceService applianceService;
    private final ApplianceOperationRepository applianceOperationRepository;

    @Transactional
    public Long save(ApplianceopSaveDto applianceopSaveDto) {
        ApplianceOperation ao = ApplianceOperation.builder()
                .appliance(applianceService.findOne(applianceopSaveDto.getAppliance_seq()))
                .member(memberService.findOne(applianceopSaveDto.getMember_seq()))
                .date(applianceopSaveDto.getDate())
                .time(applianceopSaveDto.getTime())
                .build();
        return applianceOperationRepository.save(ao);
    }

    public List<ApplianceopReturnDto> findAllAppOp(Long member_seq) {
        List<ApplianceOperation> findOps = applianceOperationRepository.findAll(member_seq);
        List<ApplianceopReturnDto> returnOps = new ArrayList<>();
        for (ApplianceOperation findOp : findOps) {
            ApplianceopReturnDto returnOp = ApplianceopReturnDto.builder()
                    .date(findOp.getDate())
                    .time(findOp.getTime())
                    .type(findOp.getAppliance().getType())
                    .serialNum(findOp.getAppliance().getSerialNum())
                    .build();
            returnOps.add(returnOp);
        }
        return returnOps;
    }

    public List<ApplianceopReturnDto> findDateAppOp(LocalDate date, Long member_seq) {
        List<ApplianceOperation> findOps = applianceOperationRepository.findByDate(date, member_seq);
        List<ApplianceopReturnDto> returnOps = new ArrayList<>();
        for (ApplianceOperation findOp : findOps) {
            ApplianceopReturnDto returnOp = ApplianceopReturnDto.builder()
                    .date(findOp.getDate())
                    .time(findOp.getTime())
                    .type(findOp.getAppliance().getType())
                    .serialNum(findOp.getAppliance().getSerialNum())
                    .build();
            returnOps.add(returnOp);
        }
        return returnOps;
    }

    public ApplianceOperation findOne(Long seq) { return applianceOperationRepository.findOne(seq);}
}