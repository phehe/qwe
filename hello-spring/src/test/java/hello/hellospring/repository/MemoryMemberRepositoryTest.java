package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
/*
*       테스트 케이스 작성 시
*       1.순서에 의존하면 안된다 (순서와 상관 없다.) -> 설계할 때 주의 해야 한다 .
*       2.한가지의 테스트 종료 될 떄 저장소 or 공용 데이터 지워 줘야 한다.
*
*
* */


    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 콜백함수 테스트 메소드 하나 실행 후 객체 저장 클리어 해줌 heap 지워주는건가?
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();

        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("(result == member) = " + (result == member));
//        Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}


