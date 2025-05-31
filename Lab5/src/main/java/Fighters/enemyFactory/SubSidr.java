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
public class SubSidr extends Enemy {

    public SubSidr(int level) {
        super();
        this.maxHP = 70;
        this.hp = 70;
        this.damage = 18;
        this.photoPath = "/subSidr.jpeg";
        setLevelStuts(level);
        this.type = "Маг";
    }

    

    @Override
    public String toString() {
        return "Саб-Сидр";
    }

}
