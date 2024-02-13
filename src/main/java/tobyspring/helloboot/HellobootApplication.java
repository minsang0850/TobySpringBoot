package tobyspring.helloboot;


import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HellobootApplication {

    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            String name = env.getProperty("my.name");
            System.out.println("name: " + name);
        };
    }

    public static void main(String[] args) {
        //톰캣 서블릿 웹서버를 만들어주는 클래스
        SpringApplication.run(HellobootApplication.class, args);
    }
}
