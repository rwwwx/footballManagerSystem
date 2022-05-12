package io.rwwwx.footballmanagersystem;

import io.rwwwx.footballmanagersystem.service.PlayerService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FootballManagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballManagerSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PlayerService playerService) {
        return args -> {

        };
    }

}
