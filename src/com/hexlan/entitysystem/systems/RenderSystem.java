package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.components.ComponentType;
import com.hexlan.entitysystem.components.ImageComponent;
import com.hexlan.entitysystem.components.PositionComponent;
import com.hexlan.entitysystem.components.RenderOrderComponent;
import com.hexlan.entitysystem.entity.Entity;

import java.awt.Graphics2D;
import java.util.*;

public class RenderSystem extends GameSystem {

    public RenderSystem() {
        neededComponents = new HashSet<>();
        neededComponents.add(ComponentType.POSITION);
        neededComponents.add(ComponentType.IMAGE);
        neededComponents.add(ComponentType.RENDER_ORDER);
    }

    @Override
    public void update() {}

    @Override
    public void draw(Graphics2D g) {

        List<Entity> entityList = new ArrayList<>(entities);

        Collections.sort(entityList, (e1, e2) -> {
            int i1 = ((RenderOrderComponent) e1.components.get(ComponentType.RENDER_ORDER)).renderOrder;
            int i2 = ((RenderOrderComponent) e2.components.get(ComponentType.RENDER_ORDER)).renderOrder;
            return (i1 > i2 ? -1 : (i1 == i2 ? 0 : 1));
        });

        for(Entity e : entityList) {
            ImageComponent ic = (ImageComponent) e.components.get(ComponentType.IMAGE);
            PositionComponent pc = (PositionComponent) e.components.get(ComponentType.POSITION);
            g.drawImage(ic.image, pc.x, pc.y, null);
        }
    }
}