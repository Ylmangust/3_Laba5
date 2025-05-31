/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.enemyFactory;

import Fighters.ActionType;
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

    public String getType() {
        return type;
    }

    public void generateMove(ActionType playerLastAction, boolean playerDebuffed, int playerHP, int playerMaxHP) {
        int enemyHP = this.getHp();

        if (this.isDebuffed()) {
            if (Math.random() < 0.6) {
                this.actionStatus = ActionType.DEFEND;
                return;
            }
            this.actionStatus = ActionType.ATTACK;
            return;
        }

        if (enemyHP < this.getMaxHP() * 0.4) {
            double prob = Math.random();
            if (prob < 0.5) {
                this.actionStatus = ActionType.DEFEND;
                return;
            }
            if (prob < 0.8) {
                this.actionStatus = ActionType.ATTACK;
                return;
            }
            if (this.getType().equals("Маг")) {
                this.actionStatus = ActionType.DEBUFF;
                return;
            }
        }

        if (playerLastAction == ActionType.ATTACK) {
            double roll = Math.random();
            if (roll < 0.4) {
                this.actionStatus = ActionType.DEFEND;
                return;
            }
            if (roll < 0.7 && this.getType().equals("Маг")) {
                this.actionStatus = ActionType.DEBUFF;
                return;
            }
            this.actionStatus = ActionType.ATTACK;
            return;
        }

        if (playerLastAction == ActionType.DEFEND) {
            double roll = Math.random();
            if (roll < 0.5) {
                this.actionStatus = ActionType.ATTACK;
                return;
            }
            if (roll < 0.8 && this.getType().equals("Маг")) {
                this.actionStatus = ActionType.DEBUFF;
                return;
            }
            this.actionStatus = ActionType.DEFEND;
            return;
        }

        if (playerDebuffed || playerHP < playerMaxHP * 0.5) {
            if (Math.random() < 0.8) {
                this.actionStatus = ActionType.ATTACK;
                return;
            }
        }

        double roll = Math.random();
        if (roll < 0.45) {
            this.actionStatus = ActionType.ATTACK;
            return;
        }
        if (roll < 0.7 && this.getType().equals("Маг")) {
            this.actionStatus = ActionType.DEBUFF;
            return;
        }
        this.actionStatus = ActionType.DEFEND;
        return;
    }

}
