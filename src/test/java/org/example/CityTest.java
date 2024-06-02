package org.example;

import org.example.model.CityPool;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTest {

    CityPool cityPool = CityPool.getInstance();

    @Test
    void getRandomCity_notNull() {
        String city = cityPool.getRandomCity();
        assertNotNull(city);
    }

    // TODO: 02.06.2024 нужен ли такой тест
    @Test
    void getRandomCity_unique() {
        int size = cityPool.getSize();

        Set<String> cities = new HashSet<>();
        for (int i = 0; i < size; i++) {
            cities.add(cityPool.getRandomCity());
        }

        assertEquals(cities.size(), size);
    }
}
