package hyu_memento.memento_back.entity;

import hyu_memento.memento_back.entity.type.GameType;
import hyu_memento.memento_back.entity.type.GameType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String datetime;

    private int result;

    @Builder
    public GamePlay(Member member, GameType type, String datetime, int result) {
        this.member = member;
        member.getGamePlays().add(this);
        this.type = type;
        this.datetime = datetime;
        this.result = result;
    }

//    //==연관관계 메서드==//
//    public void setMember(Member member) {
//        this.member = member;
//        member.getGamePlays().add(this);
//    }
}
