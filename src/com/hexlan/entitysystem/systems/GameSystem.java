package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.entity.Entity;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameSystem {
    Map<Long, Entity> entities;

    public GameSystem() {
        entities = new HashMap<>();
        System.out.println("Entity Count: "+entities.size());
    }

    public void registerEntity(Entity entity) {
        entities.put(entity.ID, entity);
    }

    public void unregisterEntity(Entity entity) {
        entities.remove(entity.ID);
    }

    public void update() {}
    public void draw(Graphics2D g) {}
}
