/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters;

/**
 *
 * @author Регина
 */
public abstract class Enemy extends Player{
    protected BehaviourPatterns behaviour;
    protected String type;

   public Enemy() {
        super();
    }
   
    public abstract void chooseBehaviourPattern();

    public ActionType[] getBehaviour(){
        return behaviour.getActions();
    }
    
}
