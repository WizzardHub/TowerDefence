package me.wizzard.towerdefence;

import lombok.Getter;
import lombok.Setter;
import lombok.var;
import me.wizzard.towerdefence.elements.GameArea;
import me.wizzard.towerdefence.elements.Wave;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TowerDefence extends JFrame implements Runnable {

    @Getter
    int width, height;

    static TowerDefence self;
    GameArea gameArea;
    Thread gameProcess;

    ScheduledExecutorService main = Executors.newSingleThreadScheduledExecutor();

    @Getter @Setter
    int health = 10;

    Wave wave;

    public TowerDefence(int width, int height) {

        Image icon = new ImageIcon("src/me/wizzard/towerdefence/res/tower.png")
                .getImage();

        this.setIconImage(icon);

        this.setSize(width, height);
        this.setTitle("Tower Defence");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.width = width;
        this.height = height;

        this.setVisible(true);

        gameArea = new GameArea(this, 25);
        wave = new Wave(this, 50, 800);

        gameProcess = new Thread(this);
        gameProcess.start();
    }

    /*
     * Game tick loop
     */

    public void run() {
        main.scheduleAtFixedRate(() -> {
            wave.tick();
            repaint();
        }, 0L, 1000L / 30L, TimeUnit.MILLISECONDS); // 30 FPS
    }

    /*
     * Game graphics event
     */

    public void paint(Graphics g) {

        /*
         * Checks if game process has started
         */
        if (gameProcess == null)
            return;

        gameArea.drawBackground(g);
        wave.paint(g);
    }

    /*
     * Game Start
     */

    public static void main(String[] args) {
        self = new TowerDefence(800, 800);
    }
}
