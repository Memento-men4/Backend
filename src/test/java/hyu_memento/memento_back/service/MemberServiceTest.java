package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.type.Gender;
import hyu_memento.memento_back.domain.type.MemberType;
import hyu_memento.memento_back.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {

        Member member = Member.builder()
                .id("sky")
                .password("1234")
                .name("hanuel")
                .phoneNumber("010-1234-5678")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022,11,20))
                .email("abc@naver.com")
                .build();

        Long saveSeq = memberService.join(member);

        Assertions.assertEquals(member.getMember_seq(), saveSeq);
    }

    @Test
    public void 중복_회원_예외() {
        Member member1 = Member.builder()
                .id("sky")
                .password("1234")
                .name("hanuel")
                .phoneNumber("010-1234-5678")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022,11,20))
                .email("abc@naver.com")
                .build();

        Member member2 = Member.builder()
                .id("sky")
                .password("1234")
                .name("hanuel")
                .phoneNumber("010-1234-5678")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022,11,20))
                .email("abc@naver.com")
                .build();

        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, ()->{
            memberService.join(member2);
        });
    }
}