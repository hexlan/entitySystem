package com.hexlan.entitysystem.components;

public class PositionComponent extends Component{
    public int x;
    public int y;

    public PositionComponent(int x, int y) {
        componentType = 0;
        this.x = x;
        this.y = y;
    }
}