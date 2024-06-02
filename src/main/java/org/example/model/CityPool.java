package org.example.model;

import java.util.List;
import java.util.Random;

public class CityPool {

    private static CityPool instance;
    private static final Random random = new Random();
    private static final List<String> cityPool = List.of(
            "Москва",
            "Грозный",
            "Санкт-Петербург",
            "Тюмень",
            "Екатеринбург",
            "Казань",
            "Севастополь",
            "Сочи",
            "Калуга",
            "Новосибирск"
    );

    private CityPool() {
    }

    public static CityPool getInstance() {
        if (instance == null) {
            instance = new CityPool();
        }
        return instance;
    }

    public String getRandomCity() {
        int randomCityId = random.nextInt(cityPool.size());
        return cityPool.get(randomCityId);
    }

    public int getSize() {
        return cityPool.size();
    }

    public boolean contains(String city) {
        return cityPool.contains(city);
    }
}
