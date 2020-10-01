package core.hello;

import core.hello.discount.RateDiscountPolicy;
import core.hello.member.MemberService;
import core.hello.member.MemberServiceImpl;
import core.hello.member.MemoryMemberRepository;
import core.hello.order.OrderSerivce;
import core.hello.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderSerivce orderSerivce (){
        return new OrderServiceImpl(new MemoryMemberRepository(),new RateDiscountPolicy());
    }

}
