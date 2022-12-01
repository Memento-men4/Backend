package hyu_memento.memento_back.controller.nugu_dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuguOutputDto {
    private String date;
    private String member_seq;
    private String quiz_content;

    @Builder
    public NuguOutputDto(String date, String member_seq, String quiz_content) {
        this.date = date;
        this.member_seq = member_seq;
        this.quiz_content = quiz_content;
    }
}
