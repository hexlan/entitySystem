package com.hexlan.entitysystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputHandler implements KeyListener {

    public class Key {
        private boolean isDown;
        private boolean wasDown;

        public Key() {
            keys.add(this);
        }

        public void update() { wasDown = isDown; }
        public void set(boolean isDown) { this.isDown = isDown; }

        public boolean isDown() { return isDown; }
        public boolean isPressed() { return isDown && !wasDown; }
        public boolean isReleased() { return !isDown && wasDown; }
    }

    ArrayList<Key> keys = new ArrayList<>();

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();

    public InputHandler(Game game) {
        game.addKeyListener(this);
    }

    public void update() {
        for(Key key : keys) {
            key.update();
        }
    }

    public void set(KeyEvent e, boolean isDown) {
        if(e.getKeyCode() == KeyEvent.VK_UP) { up.set(isDown); }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) { down.set(isDown); }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) { left.set(isDown); }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) { right.set(isDown); }
    }

    @Override
    public void keyPressed(KeyEvent e) { set(e, true); }

    @Override
    public void keyReleased(KeyEvent e) { set(e, false); }

    @Override
    public void keyTyped(KeyEvent e) {}

}