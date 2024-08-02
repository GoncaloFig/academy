package com.ctw.workstation.booking.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDto(UUID rackId, UUID requesterId, LocalDateTime bookFrom, LocalDateTime bookTo, LocalDateTime createdAt, LocalDateTime modifiedAt) {
    /*private UUID rackId;

    private UUID requesterId;

    private LocalDateTime bookFrom;

    private LocalDateTime bookTo;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;*/

}
