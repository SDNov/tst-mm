package org.example.model;

import java.util.UUID;

public class Location {
    UUID id;
    UUID ownerID;
    String city;

    public Location(UUID ownerId, String city) {
        this.id = UUID.randomUUID();
        this.ownerID = ownerId;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerID;
    }

    public String getCity() {
        return city;
    }
}
