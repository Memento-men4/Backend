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
    public final ApplianceService applianceService;

    /* 가전 생성 */
    @PostMapping("/appliance")
    public Long save(@RequestBody ApplianceSaveDto applianceSaveDto) {
        return applianceService.saveAppliance(applianceSaveDto);
    }

    /* 가전 조회 */
    @GetMapping("/appliance")
    public List<ApplianceReturnDto> allApp(@RequestParam Long member_seq) {
        return applianceService.findAllApp(member_seq);
    }

    /* 가전 날짜별 조회 */
    @GetMapping("/appliance/date")
    public List<ApplianceReturnDto> DateApp(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        return applianceService.findDateApp(date, member_seq);
    }
}
