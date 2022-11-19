package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.Record;
import hyu_memento.memento_back.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;

    /* 녹음생성 */
    @Transactional
    public Long createRecord(Record record) {
        recordRepository.save(record);
        return record.getSeq();
    }
    
    /* 날짜별 녹음 조회 */
    public List<Record> findDayRecords(LocalDate date) {
        return recordRepository.findByDate(date);
    }
}
