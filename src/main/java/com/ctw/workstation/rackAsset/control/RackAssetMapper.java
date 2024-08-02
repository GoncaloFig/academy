package com.ctw.workstation.rackAsset.control;

import com.ctw.workstation.rackAsset.entity.RackAsset;
import com.ctw.workstation.rackAsset.entity.RackAssetDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {
    RackAsset toEntity(RackAssetDto rackAssetDto);
    RackAssetDto toDto(RackAsset rackAsset);
}
