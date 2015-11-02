package com.hexlan.entitysystem.components;

import java.awt.image.BufferedImage;

public class ImageComponent extends Component{
    public BufferedImage image;

    public ImageComponent(BufferedImage image) {
        componentType = ComponentType.IMAGE;
        componentName = "ImageComponent";
        this.image = image;
    }

    @Override
    public void print() {
        System.out.println(componentName);
        System.out.println("  Image: " + image.toString());
    }
}