package com.hexlan.entitysystem.components;

import java.awt.image.BufferedImage;

public class ImageComponent extends Component{
    public BufferedImage image;

    public ImageComponent(BufferedImage image) {
        componentType = 1;
        this.image = image;
    }
}