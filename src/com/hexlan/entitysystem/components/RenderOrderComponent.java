package com.hexlan.entitysystem.components;

public class RenderOrderComponent extends Component{
    public int renderOrder;

    public RenderOrderComponent(int renderOrder) {
        componentType = ComponentType.RENDER_ORDER;
        componentName = "RenderOrderComponent";
        this.renderOrder = renderOrder;
    }

    @Override
    public void print() {
        System.out.println(componentName);
        System.out.println("  Order: " + renderOrder);
    }
}