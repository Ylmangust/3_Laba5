/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.soldier;

import Fighters.BehaviourPatterns;
import Fighters.Enemy;

/**
 *
 * @author Регина
 */
public abstract class Soldier extends Enemy {

    public Soldier() {
        super();
        this.type = "Солдат";
    }
    
    @Override
    public void chooseBehaviourPattern() {
        double probavility = Math.random();
        if (probavility < 0.5){
            super.behaviour = BehaviourPatterns.PATTERN_1;
        }else {
            super.behaviour = BehaviourPatterns.PATTERN_2;
        }
    }
}
