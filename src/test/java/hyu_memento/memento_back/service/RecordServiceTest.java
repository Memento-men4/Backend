package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.Record;
import hyu_memento.memento_back.domain.type.Gender;
import hyu_memento.memento_back.domain.type.MemberType;
import hyu_memento.memento_back.repository.MemberRepository;
import hyu_memento.memento_back.repository.RecordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class RecordServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RecordService recordService;
    @Autowired
    RecordRepository recordRepository;

    @BeforeEach
    void beforeEach() {
    }

    @Test
    public void 녹음생성() {
        Member m = Member.builder()
                .id("sky")
                .password("1234")
                .name("hanuel")
                .phoneNumber("010-1234-5678")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022,11,20))
                .email("abc@naver.com")
                .build();
        memberService.join(m);

        Record r = Record.builder()
                .member(m)
                .date(LocalDate.of(2020, 1, 20))
                .time(LocalTime.of(3, 36))
                .location("한양대학교")
                .content("오늘은 길을 가다가 석철이를 만났다.")
                .build();

        Long recordSeq = recordService.createRecord(r);
        Assertions.assertEquals(r.getSeq(), recordSeq);
    }

    @Test
    public void 날짜별_녹음조회() {
        Member m1 = Member.builder()
                .id("sky")
                .password("1234")
                .name("hanuel")
                .phoneNumber("010-1234-5678")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022,11,20))
                .email("abc@naver.com")
                .build();
        memberService.join(m1);

        Member m2 = Member.builder()
                .id("cheol")
                .password("1234")
                .name("sukcheol")
                .phoneNumber("010-1234-5678")
                .gender(Gender.MALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022,11,25))
                .email("def@naver.com")
                .build();
        memberService.join(m2);

        System.out.println(memberService.findMembers());

        Record m1_1 = Record.builder()
                .member(m1)
                .date(LocalDate.of(2020, 1, 20))
                .time(LocalTime.of(3, 36))
                .location("한양대학교")
                .content("오늘은 길을 가다가 석철이를 만났다.")
                .build();

        Record m1_2 = Record.builder()
                .member(m1)
                .date(LocalDate.of(2020, 1, 20))
                .time(LocalTime.of(3, 50))
                .location("집")
                .content("맛있는 귤을 먹었다.")
                .build();

        Record m1_3 = Record.builder()
                .member(m1)
                .date(LocalDate.of(2020, 2, 20))
                .time(LocalTime.of(9, 36))
                .location("애슐리")
                .content("초밥 100개 먹기")
                .build();

        Record m2_1 = Record.builder()
                .member(m2)
                .date(LocalDate.of(2020, 1, 20))
                .time(LocalTime.of(3, 50))
                .location("큐카페")
                .content("아아는 맛있다.")
                .build();

        Record m2_2 = Record.builder()
                .member(m2)
                .date(LocalDate.of(2020, 1, 20))
                .time(LocalTime.of(3, 36))
                .location("사근동")
                .content("마라탕 100그릇 먹기.")
                .build();

        Record m2_3 = Record.builder()
                .member(m2)
                .date(LocalDate.of(2020, 1, 20))
                .time(LocalTime.of(3, 50))
                .location("중도")
                .content("컴네 과제 했다.")
                .build();

        recordService.createRecord(m1_1);
        recordService.createRecord(m1_2);
        recordService.createRecord(m1_3);

        recordService.createRecord(m2_1);
        recordService.createRecord(m2_2);
        recordService.createRecord(m2_3);

        List<Record> dayRecords = recordService.findDayRecords(LocalDate.of(2020, 1, 20), m1);
        org.assertj.core.api.Assertions.assertThat(dayRecords).containsExactly(m1_1,m1_2);
    }
}