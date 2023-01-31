package spring.config.autoconfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import spring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class TomcatWebServerConfig {
    @Bean
    public ServletWebServerFactory serverFactory() {
        return new TomcatServletWebServerFactory();
    }
}