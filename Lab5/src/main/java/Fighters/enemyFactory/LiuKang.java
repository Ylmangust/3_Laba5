/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.enemyFactory;

/**
 *
 * @author Регина
 */
public class LiuKang extends Enemy {

    public LiuKang(int level) {
        super();
        this.maxHP = 90;
        this.hp = 90;
        this.damage = 22;
        this.photoPath = "/liuKang.jpeg";
        setLevelStuts(level);
        this.type = "Боец";
    }


    
    @Override
    public String toString(){
        return "Лю Кан";
    }

}
