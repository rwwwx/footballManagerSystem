package io.rwwwx.footballmanagersystem.service;

import io.rwwwx.footballmanagersystem.entity.Player;
import io.rwwwx.footballmanagersystem.dto.PlayerDTO;
import io.rwwwx.footballmanagersystem.entity.Team;
import io.rwwwx.footballmanagersystem.exception.InvalidIdException;
import io.rwwwx.footballmanagersystem.repository.PlayerRepository;
import io.rwwwx.footballmanagersystem.repository.TeamRepository;
import io.rwwwx.footballmanagersystem.utils.Mapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayerService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final Mapper<PlayerDTO, Player> mapper;

    public PlayerService(TeamRepository teamRepository, PlayerRepository playerRepository, Mapper<PlayerDTO, Player> mapper) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    public PlayerDTO save(PlayerDTO playerDTO) {
        Player player = mapper.convertToEntity(playerDTO);
        Team team = teamRepository.getById(playerDTO.getIdOfCurrentTeam());
        team.addPlayer(player);
        teamRepository.save(team);
        return mapper.convertToDto(playerRepository.save(player));
    }

    @Transactional(readOnly = true)
    public PlayerDTO getById(Long id) {
        if (isPlayerExists(id)) {
            return mapper.convertToDto(playerRepository.getById(id));
        } else {
            throw new InvalidIdException();
        }
    }

    @Transactional
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
