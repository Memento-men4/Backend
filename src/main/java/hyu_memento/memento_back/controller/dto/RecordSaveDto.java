package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class RecordSaveDto {
    private Long member_seq;
    private String title;
    private String description;

    @Builder
    public RecordSaveDto(Long member_seq, String title, String description) {
        this.member_seq = member_seq;
        this.title = title;
        this.description = description;
    }
}
