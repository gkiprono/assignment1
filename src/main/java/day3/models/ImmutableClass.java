package day3.models;

import java.util.HashMap;
import java.util.Map;

final class ImmutableClass {
    private final int id;
    private final String name;
    private final Map<Integer, Integer> map;

    public ImmutableClass(int id, String name) {
        this.id = id;
        this.name = name;
        map = new HashMap<>();
        map.put(1,2);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Integer> getMap() {
        return map;
    }
}
