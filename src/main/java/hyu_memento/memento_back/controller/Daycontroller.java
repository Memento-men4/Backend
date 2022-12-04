package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.ApplianceReturnDto;
import hyu_memento.memento_back.controller.dto.DayDto;
import hyu_memento.memento_back.controller.dto.RecordReturnDto;
import hyu_memento.memento_back.domain.Appliance;
import hyu_memento.memento_back.service.ApplianceService;
import hyu_memento.memento_back.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Daycontroller {
    public final RecordService recordService;
    public final ApplianceService applianceService;

    @GetMapping("/day")
    public List<DayDto> dayInfo(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        List<RecordReturnDto> dayRecords = recordService.findDayRecords(date, member_seq);
        List<ApplianceReturnDto> dateApp = applianceService.findDateApp(date, member_seq);
        List<DayDto> dayDtos = new ArrayList<>();
        for (RecordReturnDto dayRecord : dayRecords) {
            DayDto build = DayDto.builder()
                    .time(dayRecord.getTime())
                    .title(dayRecord.getTitle())
                    .description(dayRecord.getDescription())
                    .build();
            dayDtos.add(build);
        }
        for (ApplianceReturnDto applianceReturnDto : dateApp) {
            DayDto lg = DayDto.builder()
                    .time(applianceReturnDto.getSettingTime())
                    .title("LG 가전")
                    .description(applianceReturnDto.getType().toString())
                    .build();
            dayDtos.add(lg);
        }
        Collections.sort(dayDtos);
        return dayDtos;
    }
}
