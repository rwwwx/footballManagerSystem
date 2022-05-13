package io.rwwwx.footballmanagersystem.service;

import io.rwwwx.footballmanagersystem.entity.Team;
import io.rwwwx.footballmanagersystem.entity.TeamDTO;
import io.rwwwx.footballmanagersystem.repository.TeamRepository;
import io.rwwwx.footballmanagersystem.utils.Mapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;
    private final Mapper<TeamDTO, Team> mapper;

    public TeamService(TeamRepository teamRepository, Mapper<TeamDTO, Team> mapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    public TeamDTO saveNewTeam(TeamDTO teamDTO) {
        return mapper.convertToDto(teamRepository.save(mapper.convertToEntity(teamDTO)));
    }

    public TeamDTO getById(Long id) {
        return mapper.convertToDto(teamRepository.getById(id));
    }

    public TeamDTO updateTeam(Long id, TeamDTO updatedTeam) {
        return mapper.convertToDto(teamRepository.save(mapper.convertToEntity(updatedTeam)));
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

}
