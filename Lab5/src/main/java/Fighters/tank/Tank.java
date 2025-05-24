/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.tank;

import Fighters.BehaviourPatterns;
import Fighters.Enemy;

/**
 *
 * @author Регина
 */
public abstract class Tank extends Enemy {

    public Tank() {
        super();
        this.type = "Танк";
    }

    @Override
    public void chooseBehaviourPattern() {
        double probability = Math.random();
        if (probability < 0.3) {
            super.behaviour = BehaviourPatterns.PATTERN_1;
        } else if (probability < 0.9) {
            super.behaviour = BehaviourPatterns.PATTERN_2;
        } else {
            super.behaviour = BehaviourPatterns.PATTERN_3;
        }
    }
}
