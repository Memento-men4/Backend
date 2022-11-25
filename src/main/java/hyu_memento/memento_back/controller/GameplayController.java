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
    public final GameplayService gameplayService;

    /* 게임 기록 생성 */
    @PostMapping("/game")
    public Long save(@RequestBody GameSaveDto gameSaveDto) {
        return gameplayService.save(gameSaveDto);
    }

    /* 게임기록 조회 */
    @GetMapping("/game")
    public List<GameReturnDto> allGame(@RequestParam Long member_seq) {
        return gameplayService.findAllGamePlay(member_seq);
    }

    /* 게임기록 종류별 조회 */
    @GetMapping("/game/type")
    public List<GameReturnDto> typeGame(@RequestParam GameType type,  @RequestParam Long member_seq) {
        return gameplayService.findTypeGamePlay(type, member_seq);
    }

    /* 게임기록 날짜별 조회 */
    @GetMapping("/game/date")
    public List<GameReturnDto> dateGame(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam Long member_seq) {
        return gameplayService.findDayGamePlay(date, member_seq);
    }
}
