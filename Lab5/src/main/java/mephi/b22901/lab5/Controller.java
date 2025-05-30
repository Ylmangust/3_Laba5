/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab5;

import Fighters.Enemy;
import Items.Item;
import Fighters.Human;
import java.util.List;

/**
 *
 * @author Регина
 */
public class Controller {
    GUI gui;
    GameLogic game;
    
    public Controller(){
        this.gui = new GUI(this);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        game = new GameLogic(this);
    }
    
    public List <Item> getItems(){
        return game.getItems();
    }
    
    
    public void useItem(int index){
        game.useItem(index);
    }
    
    public Human getHuman(){
       return game.getHuman();
    }
    
    public Enemy getEnemy(){
        return game.getCurrentEnemy();
    }
    
    public void startGame(){
        game.startGame();
    }
    
    public void startNewRound(String statToLevelUp){
        game.startNewRound(statToLevelUp);
    }
    
    public void setLocationsNum(int roundsNum){
        game.setLocationsNum(roundsNum);
    }
}
