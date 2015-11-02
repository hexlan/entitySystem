package com.hexlan.entitysystem.components;

public class PositionComponent extends Component{
    public int x;
    public int y;

    public PositionComponent(int x, int y) {
        componentType = ComponentType.POSITION;
        componentName = "PositionComponent";
        this.x = x;
        this.y = y;
    }

    @Override
    public void print() {
        System.out.println(componentName);
        System.out.println("  X: " + x);
        System.out.println("  Y: " + y);
    }
}