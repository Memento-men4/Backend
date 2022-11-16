package hyu_memento.memento_back.entity;

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

    private int num;
    private String content;
    private boolean ans;
    private boolean userAns;
    private boolean result;

    @Builder
    public QuizContent(int num, String content, boolean ans, boolean userAns, boolean result) {
        this.num = num;
        this.content = content;
        this.ans = ans;
        this.userAns = userAns;
        this.result = result;
    }
}
