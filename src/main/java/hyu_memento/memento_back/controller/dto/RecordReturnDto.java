package hyu_memento.memento_back.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class RecordReturnDto {
    private LocalTime time;
    private String location;
    private String content;

    @Builder
    public RecordReturnDto(LocalTime time, String location, String content) {
        this.time = time;
        this.location = location;
        this.content = content;
    }
}
