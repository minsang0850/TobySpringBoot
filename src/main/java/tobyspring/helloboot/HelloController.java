package tobyspring.helloboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Controller //부트 3.0부터는 RequestMapping만으로 핸들러에 등록 x Controller 어노테이션이 필요
@RequestMapping
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    @ResponseBody //view가 아닌 String 자체를 return
    public String hello(String name) {
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
