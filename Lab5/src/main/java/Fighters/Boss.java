/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters;

/**
 *
 * @author Регина
 */
public class Boss extends Enemy {

    public Boss(int humanLvl, int humanHealth) {
        super();
        int bossHealth = (int) (humanHealth * 1.5);
        int bossDamage = 25 + humanLvl * 2;
        this.maxHP = bossHealth;
        this.hp = bossHealth;
        this.damage = bossDamage;
        this.photoPath = "src/main/resources/shaoKhan.jpeg";
    }

    @Override
    public void chooseBehaviourPattern() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
