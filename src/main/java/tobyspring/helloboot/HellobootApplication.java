package tobyspring.helloboot;


import tobyspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        //톰캣 서블릿 웹서버를 만들어주는 클래스
        SpringApplication.run(HellobootApplication.class, args);
    }
}
