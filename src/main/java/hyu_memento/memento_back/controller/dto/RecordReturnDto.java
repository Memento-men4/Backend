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
    private String title;
    private String description;

    @Builder
    public RecordReturnDto(LocalTime time, String title, String description) {
        this.time = time;
        this.title = title;
        this.description = description;
    }
}
