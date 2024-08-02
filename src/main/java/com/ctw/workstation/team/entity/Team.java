package com.ctw.workstation.team.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="T_TEAM")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@SequenceGenerator(name="teamIdGenerator", sequenceName="SEQ_TEAM_ID")
    private UUID id;

    @Column(name="NAME")
    private String name;

    @Column(name="PRODUCT")
    private String product;


    @Column(name="DEFAULT_LOCATION")
    private String defaultLocation;

    public Team(UUID id, String name, String product, String defaultLocation){
        this.id = id;
        this.name = name;
        this.product = product;
        this.defaultLocation = defaultLocation;
    }

    public Team() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", defaultLocation='" + defaultLocation + '\'' +
                '}';
    }
}
