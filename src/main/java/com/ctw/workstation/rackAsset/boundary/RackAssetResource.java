package com.ctw.workstation.rackAsset.boundary;

import com.ctw.workstation.rackAsset.entity.RackAsset;
import com.ctw.workstation.rackAsset.entity.RackAssetDto;
import com.ctw.workstation.rackAsset.control.RackAssetMapper;
import com.ctw.workstation.rackAsset.control.RackAssetRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/rackAsset")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RackAssetResource {

    @Inject
    RackAssetMapper rackAssetMapper;

    @Inject
    RackAssetRepository rackAssetRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RackAsset> getAll(){
        return rackAssetRepository.listAll();
    }

    @POST
    @Transactional
    public Response add(RackAssetDto rackAssetDto){
        RackAsset rackAsset = rackAssetMapper.toEntity(rackAssetDto);
        rackAssetRepository.persist(rackAsset);
        return Response.status(Response.Status.CREATED).entity(rackAsset).build();
    }

}
