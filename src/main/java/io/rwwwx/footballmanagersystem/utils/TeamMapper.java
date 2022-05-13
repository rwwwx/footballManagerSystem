package io.rwwwx.footballmanagersystem.utils;

import io.rwwwx.footballmanagersystem.dto.TeamDTO;
import io.rwwwx.footballmanagersystem.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper implements Mapper<TeamDTO, Team> {

    @Override
    public Team convertToEntity(TeamDTO dto) {
        Team team = new Team();
        team.setCommission(dto.getCommission());
        team.setName(dto.getName());
        team.setAccount(dto.getAccount());
        return team;
    }

    @Override
    public TeamDTO convertToDto(Team entity) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setCommission(entity.getCommission());
        teamDTO.setName(entity.getName());
        teamDTO.setAccount(entity.getAccount());
        return teamDTO;
    }

}
