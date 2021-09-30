package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


/*
*   스프링 통합 테스트 방법
* */
@SpringBootTest
@Transactional      // db 테스트하고 롤백 해줌?

class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired  MemberRepository memberRepository ;

    // test 코드 메소드명 한글로 해도 상관 없다 (직관적)
    @Test
    void 회원가입() {
        // given   뭔가가 주어졌을 때
        Member member = new Member();
        member.setName("spring");

        // when     이것을 실행 했을 때 --> 검증하려는 것 memberservice의 join()
        Long saveId = memberService.join(member);

        //then       결과가 이게 나와야 된다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);


        // 아래 있는 예외처리 간단하게 하는방법
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

       /* try {
            memberService.join(member2);
            fail("예외가 발생해야합니다");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다 .");
        }*/

        // then
    }

}