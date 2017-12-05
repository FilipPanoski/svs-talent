package es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import es.powerbutton.PowerButton;

@SpringBootApplication
public class ElectricalSystemApplication  {

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(ElectricalSystemApplication.class, args);
        ctx.getBean(PowerButton.class).click();
    }
}
