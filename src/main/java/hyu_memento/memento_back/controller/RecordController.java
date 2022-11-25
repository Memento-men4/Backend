package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.RecordReturnDto;
import hyu_memento.memento_back.controller.dto.RecordSaveDto;
import hyu_memento.memento_back.domain.Record;
import hyu_memento.memento_back.service.MemberService;
import hyu_memento.memento_back.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecordController {
    public final RecordService recordService;

    /* 녹음 생성 */
    @PostMapping("/record")
    public Long save(@RequestBody RecordSaveDto recordSaveDto) {
        return recordService.saveRecord(recordSaveDto);
    }

    /* 녹음 날짜별 조회 */
    @GetMapping("/record/date")
    public List<RecordReturnDto> dailyRecord(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        return recordService.findDayRecords(date, member_seq);
    }
}
