package hyu_memento.memento_back.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class ApplianceOperation {
    @Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applianceOperation_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="appliance_seq")
    private Appliance appliance;

    private String date;
    private String time;

    @Builder
    public ApplianceOperation(String date, String time) {
        this.date = date;
        this.time = time;
    }
}
