package hyu_memento.memento_back.controller;

import hyu_memento.memento_back.controller.dto.GameReturnDto;
import hyu_memento.memento_back.controller.dto.GameSaveDto;
import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.type.GameType;
import hyu_memento.memento_back.service.GameplayService;
import hyu_memento.memento_back.service.MemberService;
import hyu_memento.memento_back.service.RecordService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameplayController {
    public final MemberService memberService;
    public final GameplayService gameplayService;

    /* 게임 기록 생성 */
    @PostMapping("/game")
    public Long save(@RequestBody GameSaveDto gameSaveDto) {
        GamePlay game = GamePlay.builder()
                .member(memberService.findOne(gameSaveDto.getMember_seq()))
                .type(gameSaveDto.getType())
                .date(gameSaveDto.getDate())
                .time(gameSaveDto.getTime())
                .result(gameSaveDto.getResult())
                .build();
        return gameplayService.saveGamePlay(game);
    }

    /* 게임기록 조회 */
    @GetMapping("/game")
    public List<GameReturnDto> allGame(@RequestParam Long member_seq) {
        List<GamePlay> findGames = gameplayService.findAllGamePlay(member_seq);
        List<GameReturnDto> returnGames = new ArrayList<>();
        for (GamePlay game : findGames) {
            GameReturnDto returnGame = GameReturnDto.builder()
                    .type(game.getType())
                    .date(game.getDate())
                    .time(game.getTime())
                    .result(game.getResult())
                    .build();
            returnGames.add(returnGame);
        }
        return returnGames;
    }

    /* 게임기록 종류별 조회 */
    @GetMapping("/game/type")
    public List<GameReturnDto> typeGame(@RequestParam GameType type,  @RequestParam Long member_seq) {
        List<GamePlay> findGames = gameplayService.findTypeGamePlay(type, member_seq);
        List<GameReturnDto> returnGames = new ArrayList<>();
        for (GamePlay game : findGames) {
            GameReturnDto returnGame = GameReturnDto.builder()
                    .type(game.getType())
                    .date(game.getDate())
                    .time(game.getTime())
                    .result(game.getResult())
                    .build();
            returnGames.add(returnGame);
        }
        return returnGames;
    }

    /* 게임기록 날짜별 조회 */
    @GetMapping("/game/date")
    public List<GameReturnDto> dateGame(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        List<GamePlay> findGames = gameplayService.findDayGamePlay(date, member_seq);
        List<GameReturnDto> returnGames = new ArrayList<>();
        for (GamePlay game : findGames) {
            GameReturnDto returnGame = GameReturnDto.builder()
                    .type(game.getType())
                    .date(game.getDate())
                    .time(game.getTime())
                    .result(game.getResult())
                    .build();
            returnGames.add(returnGame);
        }
        return returnGames;
    }
}
