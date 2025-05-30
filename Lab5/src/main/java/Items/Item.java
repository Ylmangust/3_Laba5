/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Items;

import Fighters.Human;
import javax.swing.JOptionPane;

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

    public void useItem(Human human) {
        if (quantity > 0) {
            int currentHp = human.getMaxHP();
            human.setHp(currentHp * (1 + restorePercentage));
            quantity -= 1;
            JOptionPane.showMessageDialog(null, name + " успешно использовано!", null, JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, name + " не может быть использовано!", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return name + ", " + quantity + " шт.";
    }
}
