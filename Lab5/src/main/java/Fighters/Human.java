/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters;

/**
 *
 * @author Регина
 */
public class Human extends Player {

    private int points = 0;
    private int wins = 0;

    public Human() {
        super();
        this.level = 1;
        this.maxHP = 85;
        this.hp = 85;
        this.damage =16;
        this.photoPath = "/player.jpeg";
    }

    public void addNewWin() {
        this.wins += 1;
        this.points = (int) (50 * (1 - (maxHP - hp) / maxHP));
    }

    public void addNewBossWin() {
        this.wins += 1;
        this.points = (int) (100 * (1 - (maxHP - hp) / maxHP));
    }

    public void levelUp(String chosenStat) {
        double lvlUpCoef = 0.05;
        this.level = level+1;
        if (chosenStat.equals("Максимальное здоровье")) {
            this.hp = (int) (this.maxHP * (1 + lvlUpCoef));
            this.maxHP = (int) (this.maxHP * (1 + lvlUpCoef));
        }else if (chosenStat.equals("Урон")){
            this.damage = (int)(this.damage*(1+lvlUpCoef));
        }
    }
    
    public void updateforNewFight(){
        this.hp = this.maxHP;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    } 

}
