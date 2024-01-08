package tobyspring.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringAplication {
    public static void run(Class<?> applicationClass, String... args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//                Spring 컨테이너가 DispatcherServlet에는 applicationContext가 필요한 것을 알고 주입해줌.
//                dispatcherServlet.setApplicationContext(this);

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                                  .addMapping("/*");
                });
                webServer.start();
            }
        };
        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
