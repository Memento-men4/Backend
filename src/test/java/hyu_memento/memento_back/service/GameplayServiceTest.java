package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.type.GameType;
import hyu_memento.memento_back.domain.type.Gender;
import hyu_memento.memento_back.domain.type.MemberType;
import hyu_memento.memento_back.repository.GameplayRepository;
import hyu_memento.memento_back.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
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

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class GameplayServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    GameplayService gameplayService;
    @Autowired
    GameplayRepository gameplayRepository;

    @BeforeEach
    void beforeEach() {
        Member m1 = Member.builder()
                .id("sky")
                .password("1234")
                .name("hanuel")
                .phoneNumber("010-1234-5678")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2022, 11, 20))
                .email("abc@naver.com")
                .build();
        memberService.join(m1);

        Member m2 = Member.builder()
                .id("sky2")
                .password("1234")
                .name("hanuel2")
                .phoneNumber("010-2222-2222")
                .gender(Gender.FEMALE)
                .type(MemberType.GENERAL)
                .birthDay(LocalDate.of(2002, 2, 2))
                .email("def@naver.com")
                .build();
        memberService.join(m2);

        GamePlay g1_1 = GamePlay.builder()
                .member(m1)
                .type(GameType.COLOR)
                .date(LocalDate.of(2022, 1, 17))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();
        gameplayService.createGamePlay(g1_1);

        GamePlay g1_2 = GamePlay.builder()
                .member(m1)
                .type(GameType.MATH)
                .date(LocalDate.of(2022, 11, 20))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();
        gameplayService.createGamePlay(g1_2);

        GamePlay g1_3 = GamePlay.builder()
                .member(m1)
                .type(GameType.MATH)
                .date(LocalDate.of(2022, 3, 5))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();
        gameplayService.createGamePlay(g1_3);

        GamePlay g2_1 = GamePlay.builder()
                .member(m2)
                .type(GameType.MATH)
                .date(LocalDate.of(2022, 11, 20))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();
        gameplayService.createGamePlay(g2_1);

        GamePlay g2_2 = GamePlay.builder()
                .member(m2)
                .type(GameType.COLOR)
                .date(LocalDate.of(2022, 4, 9))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();
        gameplayService.createGamePlay(g2_2);

        GamePlay g2_3 = GamePlay.builder()
                .member(m2)
                .type(GameType.COLOR)
                .date(LocalDate.of(2022, 7, 20))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();
        gameplayService.createGamePlay(g2_3);
    }

    @AfterEach
    void aftereach() {
        // 모든 테스트 한번에 실행하면 에러가 생긴다
        // 각 테스트 실행 전에 db를 비워줘야 할 것 같은데..?
    }

    @Test
    public void 게임기록생성() {
        Member m = memberService.findOne(1L);

        GamePlay g = GamePlay.builder()
                .member(m)
                .type(GameType.COLOR)
                .date(LocalDate.of(2022, 11, 20))
                .time(LocalTime.of(11, 3))
                .result(30)
                .build();

        Long gamePlaySeq = gameplayService.createGamePlay(g);
        Assertions.assertEquals(g.getSeq(), gamePlaySeq);
    }

    @Test
    public void 개인별_게임_기록_조회() {
        Member m1 = memberService.findOne(1L);
        Member m2 = memberService.findOne(2L);

        GamePlay g1_1 = gameplayService.findOne(1L);
        GamePlay g1_2 = gameplayService.findOne(2L);
        GamePlay g1_3 = gameplayService.findOne(3L);

        GamePlay g2_1 = gameplayService.findOne(4L);
        GamePlay g2_2 = gameplayService.findOne(5L);
        GamePlay g2_3 = gameplayService.findOne(6L);

        List<GamePlay> gameRecords = gameplayService.findAllGamePlay(m2);
        assertThat(gameRecords).containsExactly(g2_1, g2_2, g2_3);
    }

    @Test
    public void 날짜별_게임_기록_조회() {
        Member m1 = memberService.findOne(1L);
        Member m2 = memberService.findOne(2L);

        GamePlay g1_1 = gameplayService.findOne(1L);
        GamePlay g1_2 = gameplayService.findOne(2L);
        GamePlay g1_3 = gameplayService.findOne(3L);

        GamePlay g2_1 = gameplayService.findOne(4L);
        GamePlay g2_2 = gameplayService.findOne(5L);
        GamePlay g2_3 = gameplayService.findOne(6L);

        List<GamePlay> gameRecords = gameplayService.findDayGamePlay(LocalDate.of(2022, 11, 20), m1);
        assertThat(gameRecords).containsExactly(g1_2);
    }

    @Test
    public void 종류별_게임_기록_조회() {
        Member m1 = memberService.findOne(1L);
        Member m2 = memberService.findOne(2L);

        GamePlay g1_1 = gameplayService.findOne(1L);
        GamePlay g1_2 = gameplayService.findOne(2L);
        GamePlay g1_3 = gameplayService.findOne(3L);

        GamePlay g2_1 = gameplayService.findOne(4L);
        GamePlay g2_2 = gameplayService.findOne(5L);
        GamePlay g2_3 = gameplayService.findOne(6L);

        List<GamePlay> gameRecords = gameplayService.findTypeGamePlay(GameType.MATH, m1);
        assertThat(gameRecords).containsExactly(g1_2,g1_3);
    }
}