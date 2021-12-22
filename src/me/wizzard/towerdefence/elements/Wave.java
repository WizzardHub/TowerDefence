package me.wizzard.towerdefence.elements;

import me.wizzard.towerdefence.TowerDefence;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Wave {

    TowerDefence context;
    final List<Enemy> enemyList = new ArrayList<>();

    public Wave(TowerDefence context, int amount, int density) {
        for (int i = 0; i < amount; i++) {
            double overflow = Math.random() * density;
            enemyList.add(new Enemy(context.getWidth() + overflow, context.getHeight() - context.getHeight() / 10.0, "Zombie", 10, Enemy.EnemyType.ZOMBIE));
        }
    }

    public void tick() {
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).update();
            if (enemyList.get(i).getX() < 0) {
                context.setHealth(context.getHealth() - 1); // todo maybe add specific damages to enemy types
            }
        }
    }

    public void paint(Graphics g) {
        enemyList.forEach(e -> e.paint(g));
    }
}
