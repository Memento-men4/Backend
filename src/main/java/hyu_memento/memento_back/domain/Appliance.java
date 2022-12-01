package hyu_memento.memento_back.domain;

import hyu_memento.memento_back.domain.type.ApplianceType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appliance_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    @OneToMany(mappedBy = "appliance", cascade = CascadeType.ALL)
    private List<ApplianceOperation> applianceOperations = new ArrayList<>();

    private String serialNum;
    @Enumerated(EnumType.STRING)
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
    public Appliance(Member member, String serialNum, ApplianceType type, LocalTime settingTime, Boolean mon, Boolean tue, Boolean wed, Boolean thr, Boolean fri, Boolean sat, Boolean sun) {
        this.member = member;
        member.getAppliances().add(this);
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

    public void addApplianceOperation(ApplianceOperation applianceOperation) {
        applianceOperations.add(applianceOperation);
        applianceOperation.setAppliance(this);
    }
}
