/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.fighter;

import Fighters.BehaviourPatterns;
import Fighters.Enemy;

/**
 *
 * @author Регина
 */
public abstract class Fighter extends Enemy {

    public Fighter() {
        super();
        this.type = "Боец";
    }
    
    @Override
    public void chooseBehaviourPattern() {
        double probavility = Math.random();
        if (probavility < 0.25) {
            super.behaviour = BehaviourPatterns.PATTERN_1;
        } else if (probavility < 0.35) {
            super.behaviour = BehaviourPatterns.PATTERN_2;
        } else {
            super.behaviour = BehaviourPatterns.PATTERN_2;
        }
    }
}
