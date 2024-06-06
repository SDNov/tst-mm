package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Location;
import org.example.model.OwnerIdPool;
import org.junit.jupiter.api.Test;

import java.io.*;
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

    @Test
    void serializerTest() throws Exception{
        UUID ownerId = UUID.randomUUID();
        Location expected = new Location(ownerId);
        List<Location> locations = List.of(expected);
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Serializer serializer = new Serializer();
            serializer.serialize(locations, outputStream);
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<Location> resultList = objectMapper
                    .readValue(outputStream.toByteArray(), new TypeReference<>() {
            });
            assertEquals(locations.size(), resultList.size());

            assertEquals(expected.getId(), resultList.get(0).getId());
        }
    }

    @Test
    void mainScenario() throws IOException {
        String filePath = "test.json";
        int N = 1;
        Worker worker = new Worker();
        File result = worker.doWork(filePath, N);
        assertTrue(result.exists());
        result.delete();
    }
}
