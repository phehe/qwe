package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service  // 스프링에 올라 올 때 멤버서비스로 등록을 해준다 ?
public class MemberService {
    // 현재 지금 클래스 테스트 하려면 ctrl + shift + T
    private final MemberRepository memberRepository;

    // 외부에서 뭔가를 넣어준다 DI라고 한다 뭔말인지 이해 안감
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *  회원가입
    * */
    public Long join(Member member) {
        // 같인 이름이 있는 중복 회원 x
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m-> {
//            throw new IllegalStateException("이미 존재하는 회원");
//        } );

        // 권장 이런쪽으로 변경
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     *  전체 회원 조회
    * */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
