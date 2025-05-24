/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.fighter;

/**
 *
 * @author Регина
 */
public class LiuKang extends Fighter {

    public LiuKang() {
        super();
        this.level = 0;
        this.maxHP = 90;
        this.hp = 90;
        this.damage = 22;
        this.photoPath = "src/main/resources/liuKang.jpeg";
    }


    
    @Override
    public String toString(){
        return "Лю Кан";
    }

}
