package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Location;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Serializer {

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public void serialize(List<Location> locations, OutputStream outputStream) throws IOException {
        objectMapper.writeValue(outputStream, locations);
    }
}
