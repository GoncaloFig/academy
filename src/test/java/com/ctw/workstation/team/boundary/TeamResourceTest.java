package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamRepository;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDto;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.spi.RuntimeConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.response.Response.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(TeamResource.class)
class TeamResourceTest {

    @InjectMock
    TeamService teamService;

    @Inject
    TeamRepository teamRepository;

    @Inject
    TeamResource teamResource;

    static TeamDto teamDto;
    static TeamDto teamDtoToFind;
    static Team teamToTestGetByName;

    @BeforeAll
    static void setUp(){
        teamDto = new TeamDto("name test", "prod test", "Lisbon");
        teamDtoToFind = new TeamDto("Team S", "Procust S", "Lisbon");
        teamToTestGetByName = new Team();
        teamToTestGetByName.setId(UUID.fromString("ba195c26-858a-47ba-806e-073d6414f600"));
        teamToTestGetByName.setName("Team S");
        teamToTestGetByName.setProduct("Procust S");
        teamToTestGetByName.setDefaultLocation("Lisbon");
    }

    @Test
    public void testGetTeams(){
        when(teamService.getTeams()).thenReturn(createMultipleTeams(3));
        //Response response;
        String response = given().contentType(ContentType.JSON)
                .when().get()
                .peek()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().body()
                .extract()
                .asString();
        assertNotNull(response);
    }

    @Test
    public void testAddTeamEndpoint(){
        //TeamDto teamDto = new TeamDto("name test", "prod test", "Lisbon");
        given().contentType(ContentType.JSON)
                .body(teamDto)
                .when().post()
                .peek()
                .then()
                    .statusCode(201)
                    .contentType(ContentType.JSON)
                    .log().body();
    }

    @Test
    public void testGetTeamByName(){
        //TeamService teamService = Mockito.mock(TeamService.class);
        //TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
        String teamName = teamDtoToFind.name();
        when(teamService.getTeamByName(teamName)).thenReturn(teamToTestGetByName);

        String response = given().contentType(ContentType.JSON)
            .pathParam("name", "Team S")
            .when().get("/{name}")
                .peek()

           .then()
               .statusCode(200)
                .body("name", is(teamToTestGetByName.getName()))
                .body("product", is(teamToTestGetByName.getProduct()))
                .body("id", is(teamToTestGetByName.getId().toString()))
                .body("defaultLocation", is(teamToTestGetByName.getDefaultLocation()))
                .log().body()
                .extract()
                .asString();

        assertNotNull(response);
    }

    @Test
    public void deleteTeam(){
        given()
                .when().delete()
                .then()
                .statusCode(200);
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
}