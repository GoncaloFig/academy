package com.ctw.workstation.rack.control;

import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackRepository implements PanacheRepositoryBase<Rack, UUID> {
    public List<Rack> getAll(){
        return listAll();
    }

    /*public boolean delete(UUID id){
       return deleteById(id);
    }*/
}