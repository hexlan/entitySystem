package com.hexlan.entitysystem.components;

public class RenderOrderComponent extends Component{
    public int renderOrder;

    public RenderOrderComponent(int renderOrder) {
        componentType = 2;
        this.renderOrder = renderOrder;
    }
}
