package com.hexlan.entitysystem;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game  extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;

    public static String NAME = "Entity System";
    public static int WIDTH = 320;
    public static int HEIGHT = 240;
    public static int SCALE = 2;

    public static boolean quit = false;

    private BufferedImage image;
    private Graphics2D g;

    public Game() {

    }

    public void start() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D)image.getGraphics();

        new Thread(this).start();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerUpdate = 1000000000/ 60; // 60FPS

        while(!quit) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerUpdate;
            lastTime = now;

            while(unprocessed >= 1) {
                update();
                unprocessed--;
            }

            draw();
        }
    }

    public void update() {

    }

    public void draw() {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
        g2.dispose();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setFocusable(true);
        game.requestFocus();

        JFrame window = new JFrame(NAME);
        window.add(game);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        game.start();
    }
}
