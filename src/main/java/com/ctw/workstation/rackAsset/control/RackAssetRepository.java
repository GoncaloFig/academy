package com.ctw.workstation.rackAsset.control;


import com.ctw.workstation.rackAsset.entity.RackAsset;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class RackAssetRepository implements PanacheRepositoryBase<RackAsset, UUID> {
    public List<RackAsset> getAll(){
        return getAll();
    }
}
