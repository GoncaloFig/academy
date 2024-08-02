package com.ctw.workstation.teamMember.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class TeamMemberDto {

    private UUID id;
    private UUID teamId;
    private String ctwId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TeamMemberDto(UUID id, UUID teamId, LocalDateTime modifiedAt, LocalDateTime createdAt, String name, String ctwId) {
        this.id = id;
        this.teamId = teamId;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.name = name;
        this.ctwId = ctwId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
