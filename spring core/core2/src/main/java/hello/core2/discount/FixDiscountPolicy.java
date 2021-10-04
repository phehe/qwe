package hello.core2.discount;

import hello.core2.member.Grade;
import hello.core2.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    /*
     *   고정할인금액 정책
     * */

    /*<--고정금액-->*/
    private int discountFixAmount = 1000;

    /*<--회원등급에 맞는 할인금액-->*/
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { // enum 열거형 상수 -> == 으로 비교한다 주소값?
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
