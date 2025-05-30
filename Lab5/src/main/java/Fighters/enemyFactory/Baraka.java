/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.enemyFactory;

import Fighters.enemyFactory.Enemy;

/**
 *
 * @author Регина
 */
public class Baraka extends Enemy {

    public Baraka(int level) {
        super();
        this.maxHP = 120;
        this.hp = 120;
        this.damage = 15;
        this.photoPath = "/baraka.jpeg";
        setLevelStuts(level);
        this.type = "Танк";
    }

    @Override
    public String toString() {
        return "Барака";
    }

}
