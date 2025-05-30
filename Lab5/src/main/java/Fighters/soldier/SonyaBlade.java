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
    
    public SonyaBlade(int level){
        super();
        this.maxHP = 100;
        this.hp = 100;
        this.damage = 20;
        this.photoPath = "/sonyaBlade.jpeg";
        setLevelStuts(level);
    }

    
    
    @Override
    public String toString(){
        return "Соня Блейд";
    }
}
