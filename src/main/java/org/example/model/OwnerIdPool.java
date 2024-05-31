package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class OwnerIdPool {
    private static OwnerIdPool instance;
    private final List<UUID> uuidList;
    private final Random random = new Random();

    private OwnerIdPool(int n) {
        List<UUID> uuidList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            uuidList.add(UUID.randomUUID());
        }
        this.uuidList = uuidList;
    }

    // TODO: 31.05.2024 параметр n при повторном вызове не работает
    public static OwnerIdPool getInstance(int n) {
        if (instance == null) {
            instance = new OwnerIdPool(n);
        }
        return instance;
    }

    public UUID getRandomUUID() {
        int randomN = random.nextInt(uuidList.size());

        return uuidList.get(randomN);
    }

    public int getSize() {
        return uuidList.size();
    }

    public boolean contains(UUID ownerId) {
        return uuidList.contains(ownerId);
    }
}
