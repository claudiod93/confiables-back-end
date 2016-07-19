package cl.confiables.config;

import cl.confiables.repository.UsuarioRepository;
import cl.confiables.repository.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "cl.confiables")
@ComponentScan(basePackages = "cl.confiables")
public class ConfiablesBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfiablesBackApplication.class, args);
    }
}
