package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.components.ComponentType;
import com.hexlan.entitysystem.entity.Entity;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public abstract class GameSystem {
    protected Set<Entity> entities;
    protected Set<ComponentType> neededComponents;

    public GameSystem() {
        entities = new HashSet<>();
        neededComponents = new HashSet<>();
    }

    public boolean hasComponents(Entity entity) {
        for(ComponentType key : entity.components.keySet()) {
             if(!neededComponents.contains(entity.components.get(key).componentType)) return false;
        }

        return true;
    }

    public boolean needsComponent(ComponentType componentType) { return neededComponents.contains(componentType); }
    public void registerEntity(Entity entity) { entities.add(entity); }
    public void unregisterEntity(Entity entity) { entities.remove(entity); }

    public abstract void update();
    public abstract void draw(Graphics2D g);
}