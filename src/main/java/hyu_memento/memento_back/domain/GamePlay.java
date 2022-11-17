package hyu_memento.memento_back.domain;

import hyu_memento.memento_back.domain.type.GameType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@Getter
@NoArgsConstructor
public class GamePlay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gameplay_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    @Enumerated(EnumType.STRING)
    private GameType type;

    private LocalDate date;
    private LocalTime time;
    private int result;

    @Builder
    public GamePlay(Member member, GameType type, LocalDate date, LocalTime time, int result) {
        this.member = member;
        member.getGamePlays().add(this);
        this.type = type;
        this.date = date;
        this.time = time;
        this.result = result;
    }

//    //==연관관계 메서드==//
//    public void setMember(Member member) {
//        this.member = member;
//        member.getGamePlays().add(this);
//    }
}
