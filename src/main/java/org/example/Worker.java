package org.example;

import org.example.model.Location;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class Worker {
    public File doWork(String filePath, int n) throws IOException {
        File file = new File(filePath);
        UUID ownerId = UUID.randomUUID();
        Location expected = new Location(ownerId);
        List<Location> locations = List.of(expected);
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            Serializer serializer = new Serializer();
            serializer.serialize(locations, outputStream);
        }
        return file;
    }
}
