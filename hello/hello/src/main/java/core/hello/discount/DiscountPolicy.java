package core.hello.discount;

import core.hello.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);


}
