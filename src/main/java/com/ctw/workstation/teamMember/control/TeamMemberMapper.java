package com.ctw.workstation.teamMember.control;

import com.ctw.workstation.teamMember.entity.TeamMember;
import com.ctw.workstation.teamMember.entity.TeamMemberDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TeamMemberMapper {
    TeamMember toEntity(TeamMemberDto teamMemberDto);
    TeamMemberDto toDto(TeamMember teamMember);
}
