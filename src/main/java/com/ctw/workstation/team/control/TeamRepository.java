package com.ctw.workstation.team.control;

import com.ctw.workstation.team.entity.Team;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;

import java.util.List;
import java.util.UUID;


@ApplicationScoped
//@Dependent
public class TeamRepository implements PanacheRepositoryBase<Team, UUID> {

    public List<Team> getAll(){
        //return getEntityManager().createQuery("select t from Team t").getResultList();
        return listAll();
    }

    public Team findByName(String name){
        return find("name", name).firstResult();
    }

}
