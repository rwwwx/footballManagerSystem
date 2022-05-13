package io.rwwwx.footballmanagersystem.service;

import io.rwwwx.footballmanagersystem.entity.Team;
import io.rwwwx.footballmanagersystem.dto.TeamDTO;
import io.rwwwx.footballmanagersystem.exception.InvalidIdException;
import io.rwwwx.footballmanagersystem.repository.TeamRepository;
import io.rwwwx.footballmanagersystem.utils.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;
    private final Mapper<TeamDTO, Team> mapper;

    public TeamService(TeamRepository teamRepository, Mapper<TeamDTO, Team> mapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    public TeamDTO save(TeamDTO teamDTO) {
        return mapper.convertToDto(teamRepository.save(mapper.convertToEntity(teamDTO)));
    }

    @Transactional(readOnly = true)
    public TeamDTO getById(Long id) {
        return mapper.convertToDto(teamRepository.getById(id));
    }

    @Transactional
    public TeamDTO updateTeam(Long id, TeamDTO updatedTeam) {
        if (isTeamExists(id)) {
            return mapper.convertToDto(teamRepository.save(mapper.convertToEntity(updatedTeam)));
        } else {
            throw new InvalidIdException();
        }
    }

    public void deleteTeam(Long id) {
        if (isTeamExists(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new InvalidIdException();
        }
    }

    private boolean isTeamExists(Long id) {
        return teamRepository.existsById(id);
    }

}
