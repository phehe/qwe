package hello.core2.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {
    /*
    *   회원저장소 구체화
    * */
    /*<--회원 저장할 Map-->*/
    private static Map<Long, Member> store = new HashMap<>();
//    ConcurrentHashMap st = new ConcurrentHashMap();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
