package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.MemberDto;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    public final MemberService memberService;

    @PostMapping("/member")
    public Long save(@RequestBody MemberDto memberDto) {
        Member member = Member.builder()
                .id(memberDto.getId())
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .phoneNumber(memberDto.getPhoneNumber())
                .gender(memberDto.getGender())
                .type(memberDto.getType())
                .birthDay(memberDto.getBirthDay())
                .email(memberDto.getEmail())
                .build();
        return memberService.join(member);
    }
}
