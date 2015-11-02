package com.hexlan.entitysystem.components;

public abstract class Component {
    public ComponentType componentType;
    public String componentName;

    public abstract void print();
}