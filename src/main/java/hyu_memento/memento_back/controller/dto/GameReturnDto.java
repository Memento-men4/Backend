package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.type.GameType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class GameReturnDto {
    private GameType type;
    private LocalDate date;
    private LocalTime time;
    private int result;

    @Builder
    public GameReturnDto(GameType type, LocalDate date, LocalTime time, int result) {
        this.type = type;
        this.date = date;
        this.time = time;
        this.result = result;
    }
}
