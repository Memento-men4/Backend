package hyu_memento.memento_back.controller.nugu_dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuguOutputDto {
    private String quiz_content;

    @Builder
    public NuguOutputDto(String quiz_content) {
        this.quiz_content = quiz_content;
    }
}
