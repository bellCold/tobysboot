package spring.helloboot;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        MySpringApplication.run(Application.class, args);
    }

}
