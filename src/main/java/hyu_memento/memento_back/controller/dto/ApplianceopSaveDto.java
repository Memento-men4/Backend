package hyu_memento.memento_back.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class ApplianceopSaveDto {
    private Long member_seq;
    private Long appliance_seq;

    private LocalDate date;
    private LocalTime time;

    @Builder
    public ApplianceopSaveDto(Long member_seq, Long appliance_seq, LocalDate date, LocalTime time) {
        this.member_seq = member_seq;
        this.appliance_seq = appliance_seq;
        this.date = date;
        this.time = time;
    }
}