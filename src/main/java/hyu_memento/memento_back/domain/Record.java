package hyu_memento.memento_back.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    private LocalDate date;
    private LocalTime time;

    private String location;
    private String content;

    @Builder
    public Record(Member member,LocalDate date, LocalTime time, String location, String content) {
        this.member = member;
        member.getRecords().add(this);
        this.date = date;
        this.time = time;
        this.location = location;
        this.content = content;
    }

//    //==연관관계 메서드==//
//    public void setMember(Member member) {
//        this.member = member;
//        member.getRecords().add(this);
//    }
}
