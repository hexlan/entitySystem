package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.entity.Entity;

import java.awt.*;

public class SystemManager {

    RenderSystem renderSystem;

    public SystemManager() {
        renderSystem = new RenderSystem(this);
    }

    public void componentAdded(Entity entity) {
        boolean hasComponents = true;
        for(int componentType : renderSystem.getNeededComponents()) {
            if(entity.components.containsKey(componentType)) {continue;}
            hasComponents = false;
            break;
        }

        if(hasComponents) { renderSystem.registerEntity(entity); }
    }

    public void componentRemoved(Entity entity) {
        if(renderSystem.entities.containsKey(entity.ID)) {
            boolean componentRemoved = false;
            for(int componentType : renderSystem.getNeededComponents()) {
                if(entity.components.containsKey(componentType)) {
                    componentRemoved = true;
                    break;
                }
            }
            if(componentRemoved) { renderSystem.unregisterEntity(entity); }
        }
    }

    public void update() {
        renderSystem.update();
    }

    public void draw(Graphics2D g) {
        renderSystem.draw(g);
    }
}
