/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mephi.b22901.lab5_override;

/**
 *
 * @author Регина
 */
public class Lab5_override {

    public static void main(String[] args) {
        /*Enemy [] enemies = {new SonyaBlade(), new LiuKang(), new Baraka(), new SubSidr()};
        for (Enemy enemy : enemies) {
            enemy.chooseBehaviourPattern();
            System.out.print(enemy.toString() + ": ");
            BehaviourPatterns.ActionType[] actions = enemy.getBehaviour();
            for (BehaviourPatterns.ActionType action : actions) {
                System.out.print(action + " ");
            }
            System.out.println("\n");
        }*/
       new Controller();
    }
}
