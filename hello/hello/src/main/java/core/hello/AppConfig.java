package core.hello;

import core.hello.discount.DiscountPolicy;
import core.hello.discount.FixDiscountPolicy;
import core.hello.discount.RateDiscountPolicy;
import core.hello.member.MemberService;
import core.hello.member.MemberServiceImpl;
import core.hello.member.MemoryMemberRepository;
import core.hello.order.OrderSerivce;
import core.hello.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderSerivce orderSerivce (){
        return new OrderServiceImpl(getMemberRepository(),discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
