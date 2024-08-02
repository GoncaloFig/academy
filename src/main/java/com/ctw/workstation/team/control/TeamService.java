package com.ctw.workstation.team.control;

import com.ctw.workstation.team.boundary.TeamResource;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.slf4j.MDC;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamService {

    //Logger logger = Logger.getLogger(TeamResource.class);

    private final TeamRepository teamRepository;

    @Inject
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Inject
    TeamMapper teamMapper;

    public List<Team> getTeams(){
        return teamRepository.getAll();
    }

    public Team addTeam(TeamDto teamDto){
        Team team = new Team();
        team.setName(teamDto.name());
        team.setProduct(teamDto.product());
        team.setDefaultLocation(teamDto.defaultLocation());
        teamRepository.persist(team);
        return team;
    }

    public Team updateTeam(UUID id, Team team){
        Team teamToUpdate = teamRepository.findById(id);
        if(teamToUpdate == null){
            throw new NotFoundException();
        }
        teamToUpdate.setName(team.getName());
        teamToUpdate.setProduct(team.getProduct());
        teamToUpdate.setDefaultLocation(team.getDefaultLocation());
        return teamToUpdate;
    }

    public Team getTeamByName(String name){
        //logger.debugv("Fetching team with id: "+ name);
        //logger.debugv("Request for Team name: %s", name);
        //Team team = teamMapper.toEntity(teamDto);
        Team team = teamRepository.findByName(name);
        //UUID requestId = UUID.randomUUID();
        //MDC.put("requestId", requestId.toString());
        //logger.debugv("Request for Team: {0}", team.toString());
        return team;
    }

    public Team deleteTeam(UUID id){
        Team teamToDeleteFind = teamRepository.findById(id);
        if(teamRepository.isPersistent(teamToDeleteFind)){
            teamRepository.delete(teamToDeleteFind);
        }

        return teamToDeleteFind;
    }
}
