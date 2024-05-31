package org.example;

import org.example.model.OwnerIdPool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerTest {

    private final static int POOL_SIZE = 500;

    OwnerIdPool ownerIdPool = OwnerIdPool.getInstance(POOL_SIZE);

    @Test
    void ownerValidId() {
        UUID id = ownerIdPool.getRandomUUID();

        assertNotNull(id);
    }

    @Test
    void a() {
        int n = 1000;
        Set<UUID> uuidSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uuidSet.add(ownerIdPool.getRandomUUID());
        }

        assertTrue(n > uuidSet.size());
    }

    @Test
    void b() {
        int size = ownerIdPool.getSize();

        assertEquals(POOL_SIZE, size);
    }




}
