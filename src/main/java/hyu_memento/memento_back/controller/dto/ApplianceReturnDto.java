package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.type.ApplianceDayStatus;
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
    private ApplianceDayStatus mon;
    private ApplianceDayStatus tue;
    private ApplianceDayStatus wed;
    private ApplianceDayStatus thr;
    private ApplianceDayStatus fri;
    private ApplianceDayStatus sat;
    private ApplianceDayStatus sun;

    @Builder
    public ApplianceReturnDto(Long appliance_seq, String serialNum, ApplianceType type, LocalTime settingTime, ApplianceDayStatus mon, ApplianceDayStatus tue, ApplianceDayStatus wed, ApplianceDayStatus thr, ApplianceDayStatus fri, ApplianceDayStatus sat, ApplianceDayStatus sun) {
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



