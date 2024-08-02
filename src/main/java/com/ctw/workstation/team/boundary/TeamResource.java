package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDto;
import com.ctw.workstation.team.control.TeamMapper;
import com.ctw.workstation.team.control.TeamRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import org.jboss.logging.Logger;
import org.slf4j.MDC;

@Path("/team")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    Logger logger = Logger.getLogger(TeamResource.class);

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamService teamService;

    @Inject
    TeamMapper teamMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getAll(){
        logger.info("Fetching all Teams");

        return teamService.getTeams();
    }

    @POST
    @Transactional
    public Response addTeam(TeamDto teamDto){
        /*Team team = new Team();
        team.setName(teamDto.name());
        team.setProduct(teamDto.name());
        team.setDefaultLocation(teamDto.defaultLocation());*/

        //Team team = teamMapper.toEntity(teamDto);
        //teamRepository.persist(team);

        teamService.addTeam(teamDto);

        return Response.status(Response.Status.CREATED).entity(teamService.getTeams()).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteTeam(@PathParam("id") UUID id){
        /*Team teamToDelete = teamMapper.toEntity(teamDto);
        if(teamRepository.isPersistent(teamToDelete)){
            teamRepository.delete(teamToDelete);
        }*/
        teamService.deleteTeam(id);
        //return Response.status(Response.Status.OK).entity(id).build();
        return Response.status(Response.Status.OK).entity(teamService.getTeams()).build();
    }

    @GET
    @Path("/{name}")
    public Response getTeamByName(@PathParam("name") String name){
        Team team = teamService.getTeamByName(name);
        return Response.status(Response.Status.OK).entity(team).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(UUID id, Team team){
        teamService.updateTeam(id, team);
        return Response.status(Response.Status.OK).entity(teamService.getTeams()).build();
    }

}
