package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDto;
import com.ctw.workstation.rack.control.RackMapper;
import com.ctw.workstation.rack.control.RackRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;
import org.jboss.logging.Logger;

@Path("/rack")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RackResource {

    @Inject
    private Logger log;

    @Inject
    RackRepository rackRepository;

    @Inject
    RackMapper rackMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rack> getAll(){
        return rackRepository.getAll();
    }

    @POST
    @Transactional
    public Response addRack(RackDto rackDto){
        Rack rack = rackMapper.toEntity(rackDto);
        log.debug("Rack added");
        /*Rack rack = new Rack();
        rack.setDefaultLocation(rackDto.getDefaultLocation());
        rack.setStatus(rackDto.getStatus());
        rack.setSerialNumber(rackDto.getSerialNumber());
        rack.setTeamId(rackDto.getTeamId());*/
        rackRepository.persist(rack);

        return Response.status(Response.Status.CREATED).entity(rack).build();
    }

    @DELETE
    @Transactional
    public Response delete(UUID id){
        //Rack rackToDelete = rackMapper.toEntity(rackDto);
        //Rack rackToDelete = rackRepository.findById(id);
        rackRepository.deleteById(id);
        return Response.status(Response.Status.OK).build();
    }


}
