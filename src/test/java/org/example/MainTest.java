package org.example;

import org.example.model.CityPool;
import org.example.model.Location;
import org.example.model.OwnerIdPool;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final OwnerIdPool ownerIdPool = OwnerIdPool.getInstance(100);
    private final CityPool cityPool = CityPool.getInstance();

    @Test
    void generateLocation() {
        Location location = new Location(ownerIdPool.getRandomUUID(), cityPool.getRandomCity());

        assertNotNull(location.getId());
        assertTrue(ownerIdPool.contains(location.getOwnerId()));
        assertTrue(cityPool.contains(location.getCity()));
    }

    @Test
    void locationIdIsUnique() {
        int numbers = ownerIdPool.getSize();
        Set<UUID> uuidSet = new HashSet<>();
        for (int i = 0; i < numbers; i++) {
            Location location = new Location(ownerIdPool.getRandomUUID(), cityPool.getRandomCity());
            uuidSet.add(location.getId());
        }

        assertEquals(numbers, uuidSet.size());
    }
}
