package hyu_memento.memento_back.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
public class QuizContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizContent_seq")
    private Long seq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quiz_seq")
    private Quiz quiz;

    private Integer num;
    private String content;
    private String ans;

    @Builder
    public QuizContent(Integer num, String content, String ans) {
        this.num = num;
        this.content = content;
        this.ans = ans;
    }
}
