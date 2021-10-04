package hello.core2.order;

import hello.core2.discount.DiscountPolicy;
import hello.core2.discount.FixDiscountPolicy;
import hello.core2.member.*;

public class OrderServiceImpl implements OrderService {
    /**
     * @Author : ha
     * @ClassName : OrderServiceImpl
     * @Date : 2021-10-04
     * @OrderService If 구현체
     **/

    public final MemberRepository memberRepository = new MemoryMemberRepository();
    public final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /*  주문요청이 들어오면
    *   회원조회
    *   할인정책 -> 회원정보
    * */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
