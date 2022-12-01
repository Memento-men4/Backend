package hyu_memento.memento_back.controller.nugu_dto;

import hyu_memento.memento_back.controller.nugu_dto.NuguOutputDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuguReturnDto {
    private String version;
    private String resultCode;
    private NuguOutputDto output;

    @Builder
    public NuguReturnDto(String version, String resultCode, NuguOutputDto output) {
        this.version = version;
        this.resultCode = resultCode;
        this.output = output;
    }
}
