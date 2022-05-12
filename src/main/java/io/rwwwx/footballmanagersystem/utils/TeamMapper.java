package io.rwwwx.footballmanagersystem.utils;

import io.rwwwx.footballmanagersystem.entity.Team;
import io.rwwwx.footballmanagersystem.entity.TeamDTO;

public class TeamMapper implements Mapper<TeamDTO, Team> {

    @Override
    public Team convertToEntity(TeamDTO dto) {
        return new Team(
                dto.getId(),
                dto.getCommission(),
                dto.getName(),
                dto.getAccount(),
                dto.getPlayers()
        );
    }

    @Override
    public TeamDTO convertToDto(Team entity) {
        return new TeamDTO(
                entity.getId(),
                entity.getCommission(),
                entity.getName(),
                entity.getAccount(),
                entity.getPlayers()
        );
    }

}
