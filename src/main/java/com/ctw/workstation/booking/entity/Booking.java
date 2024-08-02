package com.ctw.workstation.booking.entity;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teamMember.entity.TeamMember;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="T_BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "RACK_ID")
    private UUID rackId;

    @Column(name="REQUESTER_ID")
    private UUID requesterId;

    @Column(name="BOOK_FROM")
    private LocalDateTime bookFrom;

    @Column(name="BOOK_TO")
    private LocalDateTime bookTo;

    @Column(name="CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="RACK_ID", updatable = false, insertable = false, nullable = false)
    private Rack rack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="REQUESTER_ID", updatable = false, insertable = false, nullable = false)
    private TeamMember teamMember;

    public Booking(UUID id, UUID rackId, Rack rack, LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime bookTo, LocalDateTime bookFrom, UUID requesterId) {
        this.id = id;
        this.rackId = rackId;
        this.rack = rack;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.bookTo = bookTo;
        this.bookFrom = bookFrom;
        this.requesterId = requesterId;
    }

    public Booking() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getRackId() {
        return rackId;
    }

    public void setRackId(UUID rackId) {
        this.rackId = rackId;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public UUID getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(UUID requesterId) {
        this.requesterId = requesterId;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
}
