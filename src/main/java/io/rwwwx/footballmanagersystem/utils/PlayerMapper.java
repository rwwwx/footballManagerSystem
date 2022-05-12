package io.rwwwx.footballmanagersystem.utils;

import io.rwwwx.footballmanagersystem.entity.Player;
import io.rwwwx.footballmanagersystem.entity.PlayerDTO;
import org.springframework.stereotype.Component;

//TODO rework this class
@Component
public class PlayerMapper implements Mapper<PlayerDTO, Player> {

    @Override
    public Player convertToEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setFirstName(dto.getFirstName());
        player.setLastName(dto.getLastName());
        player.setAge(dto.getAge());
        player.setAmountOfExperience(dto.getAmountOfExperience());
        player.setCurrentTeam(dto.getCurrentTeam());
        return player;
    }

    @Override
    public PlayerDTO convertToDto(Player entity) {
        return new PlayerDTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge(),
                entity.getAmountOfExperience(),
                entity.getCurrentTeam()
        );
    }

}
