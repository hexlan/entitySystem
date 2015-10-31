package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.components.ImageComponent;
import com.hexlan.entitysystem.components.PositionComponent;
import com.hexlan.entitysystem.entity.Entity;

import java.awt.*;

public class RenderSystem extends GameSystem {
    SystemManager systemManager;
    private int[] neededComponents;

    public RenderSystem(SystemManager systemManager) {
        this.systemManager = systemManager;
        neededComponents = new int[] {0, 1};
    }

    public int[] getNeededComponents() { return neededComponents; }

    @Override
    public void draw(Graphics2D g) {
        for(long currentKey : entities.keySet()) {
            Entity e = entities.get(currentKey);
            ImageComponent ic = (ImageComponent) e.components.get(1);
            PositionComponent pc = (PositionComponent) e.components.get(0);
            g.drawImage(ic.image, pc.x, pc.y, null);
        }
    }
}