package com.ctw.workstation.rackAsset.entity;

import com.ctw.workstation.rack.entity.Rack;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="T_RACK_ASSET")
public class RackAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ASSET_TAG", nullable = false)
    private String assetTag;

    @Column(name="RACK_ID", nullable = false)
    private UUID rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RACK_ID", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    public RackAsset() {}

    public RackAsset(UUID id, Rack rack, UUID rackId, String assetTag) {
        this.id = id;
        this.rack = rack;
        this.rackId = rackId;
        this.assetTag = assetTag;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }
}
