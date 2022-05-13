package io.rwwwx.footballmanagersystem.service;

import io.rwwwx.footballmanagersystem.entity.Player;
import io.rwwwx.footballmanagersystem.entity.PlayerDTO;
import io.rwwwx.footballmanagersystem.exception.InvalidIdException;
import io.rwwwx.footballmanagersystem.repository.PlayerRepository;
import io.rwwwx.footballmanagersystem.utils.Mapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final Mapper<PlayerDTO, Player> mapper;

    public PlayerService(PlayerRepository playerRepository, Mapper<PlayerDTO, Player> mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    public PlayerDTO transferPlayer(Long playerId, Long newTeamId) {
        return null;
    }

    public PlayerDTO save(PlayerDTO playerDTO) {
        return mapper.convertToDto(playerRepository.save(mapper.convertToEntity(playerDTO)));
    }

    public PlayerDTO getById(Long id) {
        if (isPlayerExists(id)) {
            return mapper.convertToDto(playerRepository.getById(id));
        } else {
            throw new InvalidIdException();
        }
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO updatedPlayer) {
        if (isPlayerExists(id)) {
            return mapper.convertToDto(playerRepository.save(mapper.convertToEntity(updatedPlayer)));
        } else {
            throw  new InvalidIdException();
        }
    }

    public void deletePlayer(Long id) {
        if (isPlayerExists(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new InvalidIdException();
        }
    }

    private boolean isPlayerExists(Long id) {
        return playerRepository.existsById(id);
    }

}
