/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fighters.enemyFactory;

/**
 *
 * @author Регина
 */
public class EnemyFactory {

    public static Enemy createEnemy(String enemyName, int level, int humanHealth) {
        switch (enemyName) {
            case "Sonya Blade":
                return new SonyaBlade(level);
            case "Baraka":
                return new Baraka(level);
            case "Liu Kang":
                return new LiuKang(level);
            case "Sub Sidr":
                return new SubSidr(level);
            case "Boss":
                return new Boss(level, humanHealth);
        }
        return null;
    }
}
