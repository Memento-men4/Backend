package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.type.GameType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class GameSaveDto {
    private Long member_seq;

    private GameType type;
    private LocalDate date;
    private LocalTime time;
    private int result;

    @Builder
    public GameSaveDto(Long member_seq, GameType type, LocalDate date, LocalTime time, int result) {
        this.member_seq = member_seq;
        this.type = type;
        this.date = date;
        this.time = time;
        this.result = result;
    }
}
