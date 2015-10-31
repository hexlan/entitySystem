package com.hexlan.entitysystem.gamestates;

import java.awt.*;

public interface GameState {
    void update();
    void draw(Graphics2D g);
}