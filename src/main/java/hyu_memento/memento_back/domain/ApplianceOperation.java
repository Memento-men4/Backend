package hyu_memento.memento_back.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ApplianceOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applianceOperation_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appliance_seq")
    private Appliance appliance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;
    private LocalDate date;
    private LocalTime time;

    @Builder
    public ApplianceOperation(Member member, Appliance appliance, LocalDate date, LocalTime time) {
        this.member = member;
        member.getApplianceOperations().add(this);
        this.appliance = appliance;
        appliance.getApplianceOperations().add(this);
        this.date = date;
        this.time = time;
    }
}