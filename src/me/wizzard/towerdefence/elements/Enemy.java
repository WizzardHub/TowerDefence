package me.wizzard.towerdefence.elements;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class Enemy extends EntityLivingBase {

    EnemyType enemyType;
    double walkSpeed;

    public Enemy(double x, double y, String name, int health, EnemyType type) {
        super(x, y, name, health);
        this.enemyType = type;
        this.walkSpeed = enemyType.getWalkSpeed();
    }

    public void update() {
        setX(getX() - (5 * walkSpeed));
    }

    public void paint(Graphics g) {
        Image img = new ImageIcon(enemyType.getTexture()).getImage();
        g.drawImage(img, (int) this.getX(), (int) this.getY(), 64, 64, null);
        System.out.println("X: " + getX());
    }

    @Getter
    public enum EnemyType {
        ZOMBIE(1, 0.425, "src/me/wizzard/towerdefence/res/zombie.png"),
        SKELETON(2, 0.625, "");

        int id;
        double walkSpeed;
        String texture;
        EnemyType(int id, double walkSpeed, String texture) {
            this.id = id;
            this.walkSpeed = walkSpeed;
            this.texture = texture;
        }
    }

}
