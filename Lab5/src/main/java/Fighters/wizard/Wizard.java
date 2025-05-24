/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.wizard;

import Fighters.BehaviourPatterns;
import Fighters.Enemy;

/**
 *
 * @author Регина
 */
public abstract class Wizard extends Enemy{
    
    public Wizard() {
        super();
        this.type = "Маг";
    }
    
    @Override
    public void chooseBehaviourPattern() {
        double probavility = Math.random();
        if (probavility < 0.5) {
            super.behaviour = BehaviourPatterns.PATTERN_1;
        } else {
            super.behaviour = BehaviourPatterns.PATTERN_3;
        }
    }
    
}
