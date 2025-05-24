/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters;

/**
 *
 * @author Регина
 */
public enum BehaviourPatterns {
    
    PATTERN_1(new ActionType[]{ActionType.ATTACK, ActionType.ATTACK, ActionType.DEFEND}),
    PATTERN_2(new ActionType[]{ActionType.DEFEND, ActionType.ATTACK, ActionType.DEFEND}),
    PATTERN_3(new ActionType[]{ActionType.ATTACK, ActionType.ATTACK, ActionType.ATTACK, ActionType.ATTACK}),
    PATTERN_4(new ActionType[]{ActionType.DEBUFF});
    private final ActionType[] actions;

    BehaviourPatterns (ActionType[] actions) {
        this.actions = actions;
    }

    public ActionType[] getActions() {
        return actions;
    }

}
