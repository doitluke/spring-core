package core.hello.autowired;

import core.hello.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("TestBean.setNoBean1 =" + noBean1);
        }

        @Autowired
        public void setNoBean(@Nullable Member noBean2){
            System.out.println("TestBean.setNoBean =" + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("TestBean.setNoBean3 = " + noBean3);
        }
    }
}
