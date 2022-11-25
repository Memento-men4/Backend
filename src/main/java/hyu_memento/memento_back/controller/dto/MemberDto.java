package hyu_memento.memento_back.controller.dto;

import hyu_memento.memento_back.domain.type.Gender;
import hyu_memento.memento_back.domain.type.MemberType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private Gender gender;
    private MemberType type;
    private LocalDate birthDay;
    private String email;

    @Builder
    public MemberDto(String id, String password, String name, String phoneNumber, Gender gender, MemberType type, LocalDate birthDay, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.type = type;
        this.birthDay = birthDay;
        this.email = email;
    }
}
