/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab5_override;

import Items.Item;
import Fighters.Human;
import Fighters.Enemy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Регина
 */
public class GameLogic {

    private static List<Item> items = new ArrayList<>(Arrays.asList(new Item("Малое зелье лечения", 0.25), new Item("Большое зелье лечения", 0.5), new Item("Крест воскрешения", 0.05)));
    private static Human player;
    private static List<Enemy> enemies = new ArrayList<>();
    private static int [] enemiesNumber = {2, 4, 6, 8, 10};
    private Enemy currentEnemy;
    
    
    public static void startGame(){
        player = new Human();
        
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
        return currentEnemy;
    }
    
    public void move(){
    
    }
    

}
