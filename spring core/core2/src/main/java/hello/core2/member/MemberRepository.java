package hello.core2.member;

public interface MemberRepository {
    /*      역할 인페
    *   1. 회원 저장소
    *
    * */

    /*<--회원저장-->*/
    void save(Member member);

    /*<--회원 아이디찾기-->*/
    Member findById(Long memberId);

}
