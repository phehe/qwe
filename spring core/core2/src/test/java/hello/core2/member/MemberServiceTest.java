package hello.core2.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    /* 단위테스트 -> 순수한 자바 코드로만 테스트하는거?*/

    @Test
    void join() {
        //given 주어짐
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 실행
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 검증
        Assertions.assertThat(member).isEqualTo(findMember);
    }


}
