package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.type.ApplianceType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class ApplianceReturnDto {
    private Long appliance_seq;
    private String serialNum;
    private ApplianceType type;
    private LocalTime settingTime;
    private Boolean mon;
    private Boolean tue;
    private Boolean wed;
    private Boolean thr;
    private Boolean fri;
    private Boolean sat;
    private Boolean sun;

    @Builder
    public ApplianceReturnDto(Long appliance_seq, String serialNum, ApplianceType type, LocalTime settingTime, Boolean mon, Boolean tue, Boolean wed, Boolean thr, Boolean fri, Boolean sat, Boolean sun) {
        this.appliance_seq = appliance_seq;
        this.serialNum = serialNum;
        this.type = type;
        this.settingTime = settingTime;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thr = thr;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }
}



