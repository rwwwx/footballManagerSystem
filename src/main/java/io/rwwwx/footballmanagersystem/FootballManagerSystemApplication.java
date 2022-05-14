package io.rwwwx.footballmanagersystem;

import io.rwwwx.footballmanagersystem.dto.PlayerDTO;
import io.rwwwx.footballmanagersystem.dto.TeamDTO;
import io.rwwwx.footballmanagersystem.service.PlayerService;

import io.rwwwx.footballmanagersystem.service.TeamService;
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
    CommandLineRunner run(PlayerService playerService, TeamService teamService) {
        return args -> {
            var team = new TeamDTO(0, "team1", 999_999);
            var team2 = new TeamDTO(6, "team2", 5_001);
            var team3 = new TeamDTO(9, "team3", 10_914);
            var team4 = new TeamDTO(10, "team4", 123_119);
            teamService.save(team);
            teamService.save(team2);
            teamService.save(team3);
            teamService.save(team4);
            var playerDTO1 = new PlayerDTO
                    ("firstname1", "secondname1", 33, 3, 1L);
            var playerDTO2 = new PlayerDTO
                    ("firstname2", "secondname2", 18, 55, 2L);
            var playerDTO3 = new PlayerDTO
                    ("firstname3", "secondname3", 21, 12, 3L);
            var playerDTO4 = new PlayerDTO
                    ("firstname3", "secondname4", 41, 66, 4L);
            playerService.save(playerDTO1);
            playerService.save(playerDTO2);
            playerService.save(playerDTO3);
            playerService.save(playerDTO4);
        };
    }

}
