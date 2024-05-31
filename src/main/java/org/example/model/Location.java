package org.example.model;

import java.util.UUID;

public class Location {
    UUID id;

    public Location() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
