package hyu_memento.memento_back.service;

import hyu_memento.memento_back.controller.dto.RecordReturnDto;
import hyu_memento.memento_back.controller.dto.RecordSaveDto;
import hyu_memento.memento_back.domain.Record;
import hyu_memento.memento_back.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    public final MemberService memberService;
    private final RecordRepository recordRepository;

    /* 녹음생성 */
    @Transactional
    public Long saveRecord(RecordSaveDto recordSaveDto) {
        Record record = Record.builder()
                .member(memberService.findOne(recordSaveDto.getMember_seq()))
                .date(LocalDate.now())
                .time(LocalTime.now())
                .location(recordSaveDto.getTitle())
                .content(recordSaveDto.getDescription())
                .build();
        return recordRepository.save(record);
    }

    /* 날짜별 녹음 조회 */
    public List<RecordReturnDto> findDayRecords(LocalDate date, Long member_seq) {
        List<Record> findRecords = recordRepository.findByDate(date, member_seq);
        List<RecordReturnDto> returnRecords = new ArrayList<>();
        for (Record record : findRecords) {
            RecordReturnDto returnRecord = RecordReturnDto.builder()
                    .time(record.getTime())
                    .title(record.getLocation())
                    .description(record.getContent())
                    .build();
            returnRecords.add(returnRecord);
        }
        return returnRecords;
    }
}
