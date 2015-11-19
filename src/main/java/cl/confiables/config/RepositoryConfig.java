package cl.confiables.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "cl.confiables.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"cl.confiables.repository"})
public class RepositoryConfig {
}
