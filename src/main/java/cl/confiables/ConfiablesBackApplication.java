package cl.confiables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = "cl.confiables") 
public class ConfiablesBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfiablesBackApplication.class, args);
    }
}
