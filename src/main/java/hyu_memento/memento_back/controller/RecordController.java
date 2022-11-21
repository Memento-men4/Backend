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

    public final MemberService memberService;
    public final RecordService recordService;

    /* 녹음 생성 */
    @PostMapping("/record")
    public Long save(@RequestBody RecordSaveDto recordSaveDto) {
        Record record = Record.builder()
                .member(memberService.findOne(recordSaveDto.getMember_seq()))
                .date(LocalDate.now())
                .time(LocalTime.now())
                .location(recordSaveDto.getLocation())
                .content(recordSaveDto.getContent())
                .build();
        return recordService.saveRecord(record);
    }

    /* 녹음 날짜별 조회 */
    @GetMapping("/record")
    public List<RecordReturnDto> dailyRecord(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        List<Record> findRecords = recordService.findDayRecords(date, member_seq);
        List<RecordReturnDto> returnRecords = new ArrayList<>();
        for (Record record : findRecords) {
            RecordReturnDto returnRecord = RecordReturnDto.builder()
                    .time(record.getTime())
                    .location(record.getLocation())
                    .content(record.getContent())
                    .build();
            returnRecords.add(returnRecord);
        }
        return returnRecords;
    }
}
