package io.rwwwx.footballmanagersystem.utils;

import io.rwwwx.footballmanagersystem.entity.Player;
import io.rwwwx.footballmanagersystem.dto.PlayerDTO;
import io.rwwwx.footballmanagersystem.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper implements Mapper<PlayerDTO, Player> {

    private final TeamRepository teamRepository;

    public PlayerMapper(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Player convertToEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setAge(dto.getAge());
        player.setAmountOfExperience(dto.getAmountOfExperience());
        player.setCurrentTeam(teamRepository.getById(dto.getIdOfCurrentTeam()));
        return player;
    }

    @Override
    public PlayerDTO convertToDto(Player entity) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setFirstName(entity.getFirstName());
        playerDTO.setLastName(entity.getLastName());
        playerDTO.setAge(entity.getAge());
        playerDTO.setAmountOfExperience(entity.getAmountOfExperience());
        return playerDTO;
    }

}
