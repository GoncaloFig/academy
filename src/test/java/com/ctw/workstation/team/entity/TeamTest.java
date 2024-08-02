package com.ctw.workstation.team.entity;

import lombok.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TeamTest {

    public int add(int a, int b){
        return a+b;
    }

    @ParameterizedTest
    @MethodSource("addArguments")
    @DisplayName("Validate sum")
    void add(int expected){
        //Given
        TeamTest t = new TeamTest();
        int result = t.add(1, 1);

        assertEquals(expected, result, "Validate sum:");
    }

    static Stream<Arguments> addArguments(){
        return Stream.of(
                arguments(2),
                arguments(2)
        );
    }

    @ParameterizedTest
    //@ValueSource(strings = {"740552bd-3257-4e1e-81f3-03848234e4f3" ,"aaaa"})
    @MethodSource("getArguments")
    void getId(UUID expected, UUID id) {
        //given or arrange
        Team team = new Team();
        team.setId(id);
        //Given
        UUID result = team.getId();

        //then

        assertEquals(expected, result, "Validate if app can get Team Id");

    }

    static Stream<Arguments> getArguments() {
        return Stream.of(
            arguments("740552bd-3257-4e1e-81f3-03848234e4f3", "740552bd-3257-4e1e-81f3-03848234e4f3")
        );
    }

    //Given
    //ExternalAPI externalAPI = Mockito.mock(ExternalAPI.class);
    //Mockito.when().thenReturn();

}