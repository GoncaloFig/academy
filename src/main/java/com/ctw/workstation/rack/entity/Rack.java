package com.ctw.workstation.rack.entity;


import com.ctw.workstation.team.entity.Team;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="T_RACK")
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@SequenceGenerator(name="rackIdGenerator", sequenceName="SEQ_RACK_ID")
    private UUID id;
    //private String id;

    @Column(name="SERIAL_NUMBER", nullable = false)
    private String serialNumber;

    @Column(name="STATUS", nullable = false)
    private String status;

    @Column(name="TEAM_ID")
    private UUID teamId;

    @Column(name="DEFAULT_LOCATION")
    private String defaultLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;


    public Rack(){}

    public Rack(UUID id, String serialNumber, String status){
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
