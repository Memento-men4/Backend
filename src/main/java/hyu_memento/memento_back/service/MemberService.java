package hyu_memento.memento_back.service;

import hyu_memento.memento_back.controller.dto.MemberDto;
import hyu_memento.memento_back.domain.Member;
import hyu_memento.memento_back.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /* 회원가입 */
    @Transactional // 변경
    public Long join(MemberDto memberDto) {
        Member member = memberDto.toEntity();
        return memberRepository.save(member);
    }

    /* 전체 회원 조회 */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /* member_seq(PK)로 회원 조회 */
    public Member findOne(Long member_seq) {
        return memberRepository.findOne(member_seq);
    }

    /* id로 회원 조회 */
    public List<Member> findById(String id) {
        return memberRepository.findById(id);
    }
}
