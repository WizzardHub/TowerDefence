package me.wizzard.towerdefence.elements;

import lombok.Getter;
import lombok.Setter;

@Getter
public class EntityLivingBase {

    @Setter
    double x, y;
    String name;
    int health;

    public EntityLivingBase(double x ,double y, String name, int health) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.health = health;
    }

}
