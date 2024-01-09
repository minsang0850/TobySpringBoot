package tobyspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController //ResponseBody + Controller
public class HelloController implements ApplicationContextAware {
    private final HelloService helloService;
    private ApplicationContext applicationContext;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name") String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }
}
