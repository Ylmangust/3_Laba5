/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab5;

import Fighters.ActionType;
import Items.Item;
import Fighters.Human;
import Fighters.Enemy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Регина
 */
public class GameLogic {

    private Controller controller;
    private static final List<Item> items = new ArrayList<>(Arrays.asList(new Item("Малое зелье лечения", 0.25), new Item("Большое зелье лечения", 0.5), new Item("Крест воскрешения", 0.05)));
    private static Human player;
    private static Enemy enemy;
    private static final String [] enemies = {"Baraka", "Liu Kang", "Sub Sidr", "Sonya Blade"};
    private static final Map <Integer, Integer> allRoundsEnemiesNumber = Map.of(1, 2,
                                                                                2, 4, 
                                                                                3, 6, 
                                                                                4, 8, 
                                                                                5, 10);
    private final Map <String, Integer> locationsNumber = Map.of("current", 1, 
                                                            "total", 5);
    private int currentRoundEnemyNumber;
    private static final Random random = new Random();

    
    public GameLogic(Controller ctrl){
        this.controller = ctrl;
    }
    
    public void startGame(){
        player = new Human();
        newEnemy();
    }
    
    public void startNewRound(String stat){
        getNewItem();
        player.levelUp(stat);
        newEnemy();
    }
    
    private void newEnemy(){
        int enemyIndex = random.nextInt(enemies.length);
        String enemyName = enemies[enemyIndex];
        enemy = EnemyFactory.createEnemy(enemyName, player.getLevel(), player.getHp());
    }
    
    public List<Item> getItems(){
        return items;
    }
    
    public void getNewItem(){
        double probability = Math.random();
        if (probability < 0.25) {
            int currentQuantity = items.get(0).getQuantity();
            items.get(0).setQuantity(currentQuantity+1);
        }else if (probability < 0.4){
            int currentQuantity = items.get(1).getQuantity();
            items.get(1).setQuantity(currentQuantity+1);
        }else if (probability < 0.45){
            int currentQuantity = items.get(2).getQuantity();
            items.get(2).setQuantity(currentQuantity+1);
        }
    }
    
    public void useItem(int index) {
        items.get(index).useItem(player);
    }
    
    public Human getHuman(){
        return player;
    }
    
    public Enemy getCurrentEnemy(){
        return enemy;
    }
    
    public void move(GamePhase phase, ActionType humanAction, ActionType enemyAction){
      
    }
    
    public void setLocationsNum(int num){
        locationsNumber.put("total", num);
    }
    

}
