package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.components.Component;
import com.hexlan.entitysystem.entity.Entity;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class SystemManager {

    Set<GameSystem> systems;

    public SystemManager() {
        systems = new HashSet<>();
        systems.add(new RenderSystem(this));
    }

    public void componentAdded(Entity entity, int componentType) {
        for(GameSystem system : systems) {
            if(system.needsComponent(componentType)) {
                if(system.hasComponents(entity)){
                    system.registerEntity(entity);
                }
            }
        }
    }

    public void componentRemoved(Entity entity, int componentType) {

        for(GameSystem system : systems) {
            if(system.needsComponent(componentType)) {
                if(system.hasComponents(entity)){
                    system.unregisterEntity(entity);
                }
            }
        }
    }

    public void update() {
        for(GameSystem system : systems) {
            system.update();
        }
    }

    public void draw(Graphics2D g) {
        for(GameSystem system : systems) {
            system.draw(g);
        }
    }
}
