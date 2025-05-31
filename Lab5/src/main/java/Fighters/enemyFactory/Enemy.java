/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.enemyFactory;

import Fighters.Player;

/**
 *
 * @author Регина
 */
public abstract class Enemy extends Player {
    protected String type;

    protected void setLevelStuts(int level) {
        double lvlUpCoef = 0.05;
        this.level = level;
        if (level != 1) {
            this.hp = (int) (this.maxHP * Math.pow(1 + lvlUpCoef, level));
            this.maxHP = (int) (this.maxHP * Math.pow(1 + lvlUpCoef, level));
            this.damage = (int) (this.damage * Math.pow(1 + lvlUpCoef, level));
        }
    }
    
    public String getType(){
        return type;
    }

}
