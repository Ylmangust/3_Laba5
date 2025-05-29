/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters;

/**
 *
 * @author Регина
 */
public abstract class Player {
    protected int level;
    protected int hp;
    protected int maxHP;
    protected int damage;
    protected boolean isStunned = false;
    protected ActionType actionStatus = ActionType.ATTACK;
    protected int debuffTimer=0;
    protected String photoPath;
    
   /* public void levelUp(int level){
        double lvlUpCoef = 0.05;
        this.level = level;
        this.hp = (int)(this.maxHP*Math.pow(1+lvlUpCoef, level));
        this.maxHP = (int)(this.maxHP*Math.pow(1+lvlUpCoef, level));
        this.damage = (int)(this.damage*Math.pow(1+lvlUpCoef, level));
    }*/

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }
    
    public int getMaxHP(){
        return maxHP;
    }
    
    public void recieveStun(){
        isStunned = true;
    }

    public boolean isStunned(){
        return isStunned;
    }
    
    
    
}
