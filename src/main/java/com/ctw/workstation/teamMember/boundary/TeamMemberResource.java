package com.ctw.workstation.teamMember.boundary;

import com.ctw.workstation.teamMember.entity.TeamMember;
import com.ctw.workstation.teamMember.entity.TeamMemberDto;
import com.ctw.workstation.teamMember.control.TeamMemberMapper;
import com.ctw.workstation.teamMember.control.TeamMemberRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/teamMember")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamMemberResource {

    @Inject
    TeamMemberRepository teamMemberRepository;

    @Inject
    TeamMemberMapper teamMemberMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeamMember> getAll(){
        return teamMemberRepository.getAll();
    }

    @POST
    @Transactional
    public Response add(TeamMemberDto teamMemberDto){
        TeamMember teamMemberAdd = teamMemberMapper.toEntity(teamMemberDto);
        teamMemberRepository.persist(teamMemberAdd);
        return Response.status(Response.Status.CREATED).entity(teamMemberAdd).build();
    }
}
