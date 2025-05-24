/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items;

import Fighters.Human;

/**
 *
 * @author Регина
 */
public class Item {

    protected String name;
    protected int quantity = 0;
    protected double restorePercentage;

    public Item(String name, double hpRestored) {
        this.name = name;
        this.restorePercentage = hpRestored;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getHpRestored() {
        return restorePercentage;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String useItem(Human human) {
        String message = "";
        if (quantity > 0) {
            int currentHp = human.getMaxHP();
            human.setHp(currentHp * (1 + restorePercentage));
            quantity -= 1;
            message += name + " успешно использовано!";
        }else{
            message += name + " не может быть использовано!";
        }
        return message;
    }

    @Override
    public String toString() {
        return name + ", " + quantity + " шт.";
    }
}
