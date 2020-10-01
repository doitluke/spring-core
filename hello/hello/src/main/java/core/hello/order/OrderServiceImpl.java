package core.hello.order;

import core.hello.discount.DiscountPolicy;
import core.hello.discount.FixDiscountPolicy;
import core.hello.discount.RateDiscountPolicy;
import core.hello.member.Member;
import core.hello.member.MemberRepository;
import core.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderSerivce{

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order creteOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
