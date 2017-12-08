package twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TwitterApplication {

    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(TwitterApplication.class, args);
        context.getBean(ScanCommands.class).startApplication();
    }
}
