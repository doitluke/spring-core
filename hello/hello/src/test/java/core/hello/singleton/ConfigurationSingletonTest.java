package core.hello.singleton;

import core.hello.AppConfig;
import core.hello.member.MemberRepository;
import core.hello.member.MemberServiceImpl;
import core.hello.order.OrderService;
import core.hello.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository" + memberRepository1);
        System.out.println("orderService -> memberRepository" + memberRepository2);
        System.out.println("memberRepository" + memberRepository3);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
        Assertions.assertThat(memberRepository2).isSameAs(memberRepository3);

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("ConfigurationSingletonTest.configurationDeep" + bean);
    }
}
