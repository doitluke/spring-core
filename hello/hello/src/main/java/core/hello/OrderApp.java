package core.hello;

import core.hello.member.Grade;
import core.hello.member.Member;
import core.hello.member.MemberService;
import core.hello.member.MemberServiceImpl;
import core.hello.order.Order;
import core.hello.order.OrderSerivce;
import core.hello.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderSerivce orderSerivce = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderSerivce.creteOrder(memberId, "itemA", 10000);
    }
}
