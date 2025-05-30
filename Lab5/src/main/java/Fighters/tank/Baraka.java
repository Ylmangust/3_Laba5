/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.tank;

/**
 *
 * @author Регина
 */
public class Baraka extends Tank {

    public Baraka(int level) {
        super();
        this.maxHP = 120;
        this.hp = 120;
        this.damage = 15;
        this.photoPath = "/baraka.jpeg";
        setLevelStuts(level);
    }

    @Override
    public String toString() {
        return "Барака";
    }

}
