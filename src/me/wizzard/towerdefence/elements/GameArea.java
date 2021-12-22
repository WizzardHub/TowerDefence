package me.wizzard.towerdefence.elements;

import me.wizzard.towerdefence.TowerDefence;

import javax.swing.*;
import java.awt.*;

public class GameArea {

    int[][] grill;
    int sections;

    public GameArea(TowerDefence context, int sectionSize) {
        sections = Math.min(context.getHeight(), context.getWidth()) / sectionSize;
        grill = new int[sections][sections];
    }

    public void drawBackground(Graphics g) {
        Image img = new ImageIcon("src/me/wizzard/towerdefence/res/bg.png").getImage();
        g.drawImage(img, 0, 0, 800, 800, null);
    }
}
