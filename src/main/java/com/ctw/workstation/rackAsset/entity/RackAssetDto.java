package com.ctw.workstation.rackAsset.entity;

import java.util.UUID;

public class RackAssetDto {

    private String assetTag;
    private UUID rackId;

    public RackAssetDto(String assetTag, UUID rackId) {
        this.assetTag = assetTag;
        this.rackId = rackId;
    }

    public RackAssetDto() {}

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }
}
