/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.enemyFactory;

/**
 *
 * @author Регина
 */
public class Boss extends Enemy {

    public Boss(int humanLvl, int humanHealth) {
        super();
        this.type = "Босс";
        int bossHealth = (int) (humanHealth * 1.5);
        int bossDamage = 25 + humanLvl * 2;
        this.level = humanLvl;
        this.maxHP = bossHealth;
        this.hp = bossHealth;
        this.damage = bossDamage;
        this.photoPath = "/shaoKhan.jpeg";
    }

    
    @Override
    public String toString(){
        return "Шао Кхан";
    }
}
