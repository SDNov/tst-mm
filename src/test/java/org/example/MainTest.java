package org.example;

import org.example.model.Location;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void generateLocation() {
        Location location = new Location();

        assertNotNull(location.getId());
    }

    @Test
    void locationIdIsUnique() {
        int numbers = 1000;
        Set<UUID> uuidSet = new HashSet<>();
        for (int i = 0; i < numbers; i++) {
            Location location = new Location();
            uuidSet.add(location.getId());
        }

        assertEquals(numbers, uuidSet.size());
    }
}
