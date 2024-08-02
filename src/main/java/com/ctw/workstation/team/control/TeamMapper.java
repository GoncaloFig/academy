package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TeamMapper {
    Team toEntity(TeamDto teamDto);
    TeamDto toDto(Team team);

    //ArrayList<Team> toEntity(ArrayList<TeamDto> teamDto);
    //ArrayList<TeamDto> toDto(ArrayList<Team> team);
}
