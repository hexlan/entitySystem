package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.entity.Entity;
import com.hexlan.entitysystem.components.Component;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GameSystem {
    protected Set<Entity> entities;
    protected Set<Integer> neededComponents;

    public GameSystem() {
        entities = new HashSet<>();
        neededComponents = new HashSet<>();
    }

    public boolean hasComponents(Entity entity) {
        for(int key : entity.components.keySet()) {
             if(!neededComponents.contains(entity.components.get(key).componentType)) return false;
        }

        return true;
    }

    public boolean needsComponent(int componentType) { return neededComponents.contains(componentType); }
    public void registerEntity(Entity entity) { entities.add(entity); }
    public void unregisterEntity(Entity entity) { entities.remove(entity); }

    public void update() {}
    public void draw(Graphics2D g) {}
}