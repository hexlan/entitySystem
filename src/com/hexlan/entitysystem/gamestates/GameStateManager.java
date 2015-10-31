package com.hexlan.entitysystem.gamestates;

import com.hexlan.entitysystem.InputHandler;
import com.hexlan.entitysystem.systems.SystemManager;

import java.awt.*;

public class GameStateManager {
    InputHandler input;
    SystemManager systemManager;

    GameState currentState;

    public GameStateManager(InputHandler input, SystemManager systemManager) {
        this.input = input;
        this.systemManager = systemManager;

        currentState = new TestState(this, input, systemManager);
    }

    public void setState(GameState newState) {
        currentState = newState;
    }

    public void update() {
        currentState.update();
    }

    public void draw(Graphics2D g) {
        currentState.draw(g);
    }
}