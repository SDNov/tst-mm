package org.example.model;

import java.util.UUID;

public class Location {
    UUID id;
    UUID ownerID;

    public Location(UUID ownerId) {
        this.id = UUID.randomUUID();
        this.ownerID = ownerId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerID;
    }
}
