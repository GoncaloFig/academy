package com.ctw.workstation.rack.entity;

import java.util.UUID;

public class RackDto {

    //private UUID id;
    private String serialNumber;
    private String status;
    private UUID teamId;
    private String defaultLocation;

    public RackDto(){

    }

    public RackDto(String serialNumber, String status, UUID teamId, String defaultLocation){
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
        this.defaultLocation = defaultLocation;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}

