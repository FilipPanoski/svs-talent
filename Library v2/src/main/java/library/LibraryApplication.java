package library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LibraryApplication {

    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
        context.getBean(BookService.class).startApplication();
    }
}
