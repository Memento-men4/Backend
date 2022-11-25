package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.type.ApplianceType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class ApplianceopReturnDto {
    private LocalDate date;
    private LocalTime time;
    private ApplianceType type;
    private String serialNum;

    @Builder
    public ApplianceopReturnDto(LocalDate date, LocalTime time, ApplianceType type, String serialNum) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.serialNum = serialNum;
    }
}
