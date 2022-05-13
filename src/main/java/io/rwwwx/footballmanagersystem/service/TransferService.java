package io.rwwwx.footballmanagersystem.service;

import io.rwwwx.footballmanagersystem.entity.Player;
import io.rwwwx.footballmanagersystem.entity.PlayerDTO;
import io.rwwwx.footballmanagersystem.entity.Team;
import io.rwwwx.footballmanagersystem.exception.AccountException;
import io.rwwwx.footballmanagersystem.exception.InvalidIdException;
import io.rwwwx.footballmanagersystem.repository.PlayerRepository;
import io.rwwwx.footballmanagersystem.repository.TeamRepository;
import io.rwwwx.footballmanagersystem.utils.Mapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransferService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final Mapper<PlayerDTO, Player> mapper;

    public TransferService(PlayerRepository playerRepository, TeamRepository teamRepository, Mapper<PlayerDTO, Player> mapper) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    @Transactional
    public PlayerDTO transferPlayer(Long playerId, Long newTeamId) throws RuntimeException {
        if (!playerRepository.existsById(playerId) && !teamRepository.existsById(newTeamId)) {
            throw new InvalidIdException();
        }
        Player player = playerRepository.getById(playerId);
        Team newTeam = teamRepository.getById(newTeamId);
        int transferPrice = (player.getAmountOfExperience() * 100_000 / player.getAge());
        int commissionForTeam = (transferPrice * player.getCurrentTeam().getCommission()) / 100;
        int transferFullPrice =  transferPrice + commissionForTeam;
        if (newTeam.getAccount() < transferFullPrice) {
            throw new AccountException();
        }
        player.setCurrentTeam(newTeam);
        newTeam.addPlayer(player);
        teamRepository.save(newTeam);
        playerRepository.save(player);
        return mapper.convertToDto(playerRepository.getById(playerId));
    }

}
