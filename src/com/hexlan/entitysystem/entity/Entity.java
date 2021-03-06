package com.hexlan.entitysystem.entity;

import com.hexlan.entitysystem.components.Component;
import com.hexlan.entitysystem.components.ComponentType;
import com.hexlan.entitysystem.systems.SystemManager;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    public static long currentEntityID = 0;
    public long ID;

    public Map<ComponentType, Component> components;

    SystemManager systemManager;

    public Entity(SystemManager systemManager) {
        ID = currentEntityID;
        currentEntityID++;

        components = new HashMap<>();
        this.systemManager = systemManager;
    }

    public void addComponent(Component componentToAdd) {
        if(!components.containsKey(componentToAdd.componentType)) {
            components.put(componentToAdd.componentType, componentToAdd);
            systemManager.componentAdded(this, componentToAdd.componentType);
        }
    }

    public void removeComponent(ComponentType componentType) {
        if(components.containsKey(componentType)) {
            components.remove(componentType);
            systemManager.componentRemoved(this, componentType);
        }
    }

    public void print() {
        System.out.println("Components:");
        components.values().forEach(component -> component.print());
    }
}