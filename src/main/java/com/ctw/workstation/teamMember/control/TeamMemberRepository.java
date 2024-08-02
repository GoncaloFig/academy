package com.ctw.workstation.teamMember.control;

import com.ctw.workstation.teamMember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepositoryBase<TeamMember, UUID> {
    public List<TeamMember> getAll(){
        return listAll();
    }
}
