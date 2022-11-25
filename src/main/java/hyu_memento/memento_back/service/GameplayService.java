package hyu_memento.memento_back.service;

import hyu_memento.memento_back.controller.dto.GameReturnDto;
import hyu_memento.memento_back.controller.dto.GameSaveDto;
import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.type.GameType;
import hyu_memento.memento_back.repository.GameplayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameplayService {
    public final MemberService memberService;
    private final GameplayRepository gameplayRepository;

    /* 게임 기록 생성 */
    @Transactional
    public Long save(GameSaveDto gameSaveDto) {
        GamePlay game = GamePlay.builder()
                .member(memberService.findOne(gameSaveDto.getMember_seq()))
                .type(gameSaveDto.getType())
                .date(gameSaveDto.getDate())
                .time(gameSaveDto.getTime())
                .result(gameSaveDto.getResult())
                .build();
        return gameplayRepository.save(game);
    }

    /* (개인별) 모든 게임 기록 조회 */
    public List<GameReturnDto> findAllGamePlay(Long member_seq) {
        List<GamePlay> findGames = gameplayRepository.findAll(member_seq);
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

    /* (개인별) 종류별 게임 기록 조회 */
    public List<GameReturnDto> findTypeGamePlay(GameType type, Long member_seq) {
        List<GamePlay> findGames = gameplayRepository.findByType(type, member_seq);
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

    /* (개인별) 날짜별 게임 기록 조회 */
    public List<GameReturnDto> findDayGamePlay(LocalDate date, Long member_seq) {
        List<GamePlay> findGames = gameplayRepository.findByDate(date, member_seq);
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

    /* seq(PK)로 조회 */
    public GamePlay findOne(Long seq) {
        return gameplayRepository.findOne(seq);
    }
}
