package org.example;

import org.example.model.Location;
import org.example.model.OwnerIdPool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final OwnerIdPool pool = OwnerIdPool.getInstance(100);
    @Test
    void generateLocation() {
        Location location = new Location(pool.getRandomUUID());

        assertNotNull(location.getId());
        assertTrue(pool.contains(location.getOwnerId()));
    }

    @Test
    void locationIdIsUnique() {
        int numbers = pool.getSize();
        Set<UUID> uuidSet = new HashSet<>();
        for (int i = 0; i < numbers; i++) {
            Location location = new Location(pool.getRandomUUID());
            uuidSet.add(location.getId());
        }

        assertEquals(numbers, uuidSet.size());
    }
}
