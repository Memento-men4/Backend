package hyu_memento.memento_back.service;

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
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = findById(member.getId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
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
