package hyu_memento.memento_back.service;

import hyu_memento.memento_back.domain.GamePlay;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.domain.type.GameType;
import hyu_memento.memento_back.repository.GameplayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameplayService {

    private final GameplayRepository gameplayRepository;

    /* 게임기록생성 */
    @Transactional
    public Long createGamePlay(GamePlay gamePlay) {
        gameplayRepository.save(gamePlay);
        return gamePlay.getSeq();
    }

    /* (개인별) 모든 게임 기록 조회 */
    public List<GamePlay> findAllGamePlay(Member member) {
        return gameplayRepository.findAll(member.getMember_seq());
    }

    /* (개인별) 날짜별 게임 기록 조회 */
    public List<GamePlay> findDayGamePlay(LocalDate date, Member member) {
        return gameplayRepository.findByDate(date, member.getMember_seq());
    }

    /* (개인별) 종류별 게임 기록 조회 */
    public List<GamePlay> findTypeGamePlay(GameType type, Member member) {
        return gameplayRepository.findByType(type, member.getMember_seq());
    }
}
