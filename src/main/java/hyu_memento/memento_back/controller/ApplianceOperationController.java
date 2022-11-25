package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.ApplianceopSaveDto;
import hyu_memento.memento_back.controller.dto.ApplianceopReturnDto;
import hyu_memento.memento_back.domain.ApplianceOperation;
import hyu_memento.memento_back.service.ApplianceOperationService;
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
public class ApplianceOperationController {
    public final ApplianceOperationService applianceOperationService;

    /* 가전 실행 기록 생성 */
    @PostMapping("/appliance/run")
    public Long save(@RequestBody ApplianceopSaveDto applianceopSaveDto) {
        return applianceOperationService.save(applianceopSaveDto);
    }

    /* 가전 실행 기록 조회 */
    @GetMapping("/appliance/run")
    public List<ApplianceopReturnDto> allAppOp(@RequestParam Long member_seq) {
        return applianceOperationService.findAllAppOp(member_seq);
    }

    /* 가전 실행 기록 날짜별 조회 */
    @GetMapping("/appliance/run/date")
    public List<ApplianceopReturnDto> DateAppOp(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        return applianceOperationService.findDateAppOp(date, member_seq);
    }
}