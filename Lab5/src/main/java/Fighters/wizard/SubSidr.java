/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.wizard;

/**
 *
 * @author Регина
 */
public class SubSidr extends Wizard {

    public SubSidr() {
        super();
        this.level = 0;
        this.maxHP = 70;
        this.hp = 70;
        this.damage = 18;
        this.photoPath = "src/main/resources/subSidr.jpeg";
    }

    

    @Override
    public String toString() {
        return "Саб-Сидр";
    }

}
