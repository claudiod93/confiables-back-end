package cl.confiables.config;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@SpringBootApplication
//@EnableAsync
//@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages = "cl.confiables")
//@ComponentScan(basePackages = "cl.confiables")
@Configuration
@ComponentScan
public class ConfiablesBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfiablesBackApplication.class, args);
        
    }
}
