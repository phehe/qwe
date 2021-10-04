package hello.core2.member;

public class MemberServiceImpl implements MemberService {
    /*
     *   회원서비스 구현체
     *
     * */
    private static MemberRepository memberRepository = new MemoryMemberRepository();

    /*<--회원가입-->*/
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /*<--회원조회-->*/
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
