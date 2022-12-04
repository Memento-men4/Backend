package hyu_memento.memento_back.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class DayDto implements Comparable<DayDto> {
    private LocalTime time;
    private String title;
    private String description;

    @Builder
    public DayDto(LocalTime time, String title, String description) {
        this.time = time;
        this.title = title;
        this.description = description;
    }

    @Override
    public int compareTo(DayDto d) {
        int i = time.toSecondOfDay();
        int j = d.getTime().toSecondOfDay();
        return i-j;
    }
}
