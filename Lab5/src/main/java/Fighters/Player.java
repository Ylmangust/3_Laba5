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
    protected boolean isDebuffed = false;
    protected ActionType actionStatus;
    protected int debuffTimer=0;
    protected String photoPath;
    
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
    
    public String getPhotoPath(){
        return photoPath;
    }

    public void setIsStunned(boolean isStunned) {
        this.isStunned = isStunned;
    }

    public void setActionStatus(ActionType actionStatus) {
        this.actionStatus = actionStatus;
    }

    public void setDebuffTimer(int debuffTimer) {
        this.debuffTimer = debuffTimer;
    }

    public ActionType getActionStatus() {
        return actionStatus;
    }

    public int getDebuffTimer() {
        return debuffTimer;
    }

    public boolean isDebuffed() {
        return isDebuffed;
    }

    public void setIsDebuffed(boolean isDebuffed) {
        this.isDebuffed = isDebuffed;
    }
    
    public void setHp(double hp) {
        this.hp = (int)hp;
    }
    
    
    
}
