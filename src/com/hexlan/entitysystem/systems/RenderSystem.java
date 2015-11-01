package com.hexlan.entitysystem.systems;

import com.hexlan.entitysystem.components.ImageComponent;
import com.hexlan.entitysystem.components.PositionComponent;
import com.hexlan.entitysystem.components.RenderOrderComponent;
import com.hexlan.entitysystem.entity.Entity;

import java.awt.*;
import java.util.*;
import java.util.List;

public class RenderSystem extends GameSystem {
    private SystemManager systemManager;


    public RenderSystem(SystemManager systemManager) {
        this.systemManager = systemManager;
        neededComponents = new HashSet<>();
        neededComponents.add(0);
        neededComponents.add(1);
        neededComponents.add(2);
    }

    @Override
    public void draw(Graphics2D g) {

        List<Entity> entityList = new ArrayList<Entity>(entities);

        Collections.sort(entityList, new Comparator<Entity>() {
            public int compare(Entity e1, Entity e2) {
                Integer i1 = ((RenderOrderComponent)e1.components.get(2)).renderOrder;
                Integer i2 = ((RenderOrderComponent)e2.components.get(2)).renderOrder;
                return (i1 > i2 ? -1 : (i1 == i2 ? 0 : 1));
            }
        });

        for(Entity e : entityList) {
            ImageComponent ic = (ImageComponent) e.components.get(1);
            PositionComponent pc = (PositionComponent) e.components.get(0);
            g.drawImage(ic.image, pc.x, pc.y, null);
        }
    }
}