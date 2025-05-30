/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Fighters;

/**
 *
 * @author Регина
 */
public enum ActionType {
    ATTACK("атака"), DEFEND("защита"), DEBUFF("ослабление"), STUNNED("оглушен"); //debuff - ослаблен (новое действие), stunned - оглушен (вариант защита-защита)
    
    private final String text;

    private ActionType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
