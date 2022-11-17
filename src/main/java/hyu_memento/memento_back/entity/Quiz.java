package hyu_memento.memento_back.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_seq")
    private Member member;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizContent> quizContents = new ArrayList<>();

    private LocalDate date;

    private int result;

    @Builder
    public Quiz(Member member, LocalDate date) {
        this.member = member;
        member.getQuizs().add(this);
        this.date = date;
    }

    //==연관관계 메서드==//
//    public void setMember(Member member) {
//        this.member = member;
//        member.getQuizs().add(this);
//    }

    public void addQuizContent(QuizContent quizContent) {
        quizContents.add(quizContent);
        quizContent.setQuiz(this);
    }

    // TODO : result 계산해서 넣어주는 method
}
