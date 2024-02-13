package tobyspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import tobyspring.config.ConditionalMyOnClass;
import tobyspring.config.MyAutoConfiguration;

@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@MyAutoConfiguration
public class TomcatWebServerConfig {

    @Value("${contextPath}")
    String contextPath;

    @Value("${port:8080}")
    int port;

    @Bean("tomcatServletWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties serverProperties) {
        var factory = new TomcatServletWebServerFactory();
        System.out.println(serverProperties.getContextPath());
        factory.setContextPath(serverProperties.getContextPath());
        factory.setPort(serverProperties.getPort());
        return factory;
    }

    @Bean
    public ServerProperties serverProperties(Environment environment) {
        return Binder.get(environment).bind("", ServerProperties.class).get();
    }
}
