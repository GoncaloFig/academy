package com.ctw.workstation.team.control;

import com.ctw.workstation.team.boundary.TeamResource;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDto;
import io.quarkus.test.InjectMock;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;


class TeamServiceTest {

    //@Inject
    //TeamRepository teamRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamService teamService;

    private TeamDto teamDto;

    @BeforeEach
    public void setUp(){
        //mockTeamService = Mockito.mock(TeamService.class);
    }

    @Test
    void getAllTeams() {

        TeamService mockTeamService = Mockito.mock(TeamService.class);
        List<Team> mockTeams = createMultipleTeams(2);
        when(mockTeamService.getTeams()).thenReturn(mockTeams);

        List<Team> result = mockTeamService.getTeams();

        assertNotNull(result);
        assertEquals(2,result.size());

    }

    @Test
    void addNewTeam(){
        TeamDto newTeam = createTeamDto();
        TeamRepository teamRepository = new TeamRepository();
        TeamService teamService = new TeamService(teamRepository);
        //TeamService teamService = Mockito.mock(TeamService.class);
        //TeamRepository mockTeamRepository = Mockito.mock(TeamRepository.class);
        List<Team> initialList = teamService.getTeams();


        teamService.addTeam(newTeam);
        List<Team> updatedList = teamService.getTeams();
        assertEquals(initialList.size() +1, updatedList.size());

    }

    List<Team> createMultipleTeams(int number){
        return Stream.generate(() -> {
            Team team = new Team();
            team.setId(UUID.randomUUID());
            team.setProduct("x");
            team.setDefaultLocation("Lisbon");
            team.setName("y");
            return team;
        })
        .limit(number)
        .collect(Collectors.toList());

    }

    TeamDto createTeamDto(){
        return new TeamDto("Test", "Prod", "Lisbon");
    }
}

