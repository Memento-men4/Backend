package hyu_memento.memento_back.entity;

import hyu_memento.memento_back.entity.type.ApplianceStatus;
import hyu_memento.memento_back.entity.type.ApplianceType;
import hyu_memento.memento_back.entity.type.ApplianceStatus;
import hyu_memento.memento_back.entity.type.ApplianceType;
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

    @Enumerated(EnumType.STRING)
    private ApplianceType type;

    @Enumerated(EnumType.STRING)
    private ApplianceStatus status;

    private LocalTime settingTime;

    @Builder
    public Appliance(Member member, ApplianceType type, ApplianceStatus status, LocalTime settingTime) {
        this.member = member;
        member.getAppliances().add(this);
        this.type = type;
        this.status = status;
        this.settingTime = settingTime;
    }

    public void addApplianceOperation(ApplianceOperation applianceOperation) {
        applianceOperations.add(applianceOperation);
        applianceOperation.setAppliance(this);
    }
}
