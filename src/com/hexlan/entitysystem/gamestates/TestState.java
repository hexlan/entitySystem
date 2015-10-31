package com.hexlan.entitysystem.gamestates;

import com.hexlan.entitysystem.Game;
import com.hexlan.entitysystem.InputHandler;
import com.hexlan.entitysystem.components.ImageComponent;
import com.hexlan.entitysystem.components.PositionComponent;
import com.hexlan.entitysystem.entity.Entity;
import com.hexlan.entitysystem.systems.SystemManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;

public class TestState implements GameState {

    GameStateManager gameStateManager;
    InputHandler input;
    SystemManager systemManager;

    ArrayList<Entity> entities;

    public TestState(GameStateManager gameStateManager, InputHandler input, SystemManager systemManager) {
        this.gameStateManager = gameStateManager;
        this.input = input;
        this.systemManager = systemManager;

        entities = new ArrayList<>();

        Entity e = new Entity(systemManager);
        PositionComponent pc = new PositionComponent(50, 50);
        ImageComponent ic = null;
        try {
            ic = new ImageComponent(ImageIO.read(getClass().getResourceAsStream("/image.png")));
        }
        catch(Exception ex) {}
        e.addComponent(pc);
        e.addComponent(ic);

        entities.add(e);
    }

    @Override
    public void update() {
        if(input.up.isPressed()) { entities.get(0).removeComponent(0); }
        if(input.down.isPressed()) { entities.get(0).print(); }
        if(input.left.isPressed()) {
            entities.get(0).addComponent(new PositionComponent(200, 50));
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
    }
}
