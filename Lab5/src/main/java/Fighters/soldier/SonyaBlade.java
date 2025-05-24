/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.soldier;

/**
 *
 * @author Регина
 */
public class SonyaBlade extends Soldier{
    
    public SonyaBlade(){
        super();
        this.level = 0;
        this.maxHP = 100;
        this.hp = 100;
        this.damage = 20;
        this.photoPath = "src/main/resources/sonyaBlade.jpeg";
    }

    
    
    @Override
    public String toString(){
        return "Соня Блейд";
    }
}
