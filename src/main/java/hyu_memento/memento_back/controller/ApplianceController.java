package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.ApplianceReturnDto;
import hyu_memento.memento_back.controller.dto.ApplianceSaveDto;
import hyu_memento.memento_back.controller.dto.GameReturnDto;
import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.type.GameType;
import hyu_memento.memento_back.service.ApplianceService;
import hyu_memento.memento_back.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplianceController {
    public final MemberService memberService;
    public final ApplianceService applianceService;

    /* 가전 생성 */
    @PostMapping("/appliance")
    public Long save(@RequestBody ApplianceSaveDto applianceSaveDto) {
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
        return applianceService.saveAppliance(appliance);
    }

    /* 가전 조회 */
    @GetMapping("/appliance")
    public List<ApplianceReturnDto> findAll(@RequestParam Long member_seq) {
        List<Appliance> findAppliances = applianceService.findAll(member_seq);
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

    /* 가전 날짜별 조회 */
    @GetMapping("/appliance/date")
    public List<ApplianceReturnDto> findByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        List<Appliance> findAppliances = applianceService.findDate(date, member_seq);
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
}
