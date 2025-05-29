/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab5;

import Fighters.Boss;
import Fighters.Enemy;
import Fighters.fighter.LiuKang;
import Fighters.soldier.SonyaBlade;
import Fighters.tank.Baraka;
import Fighters.wizard.SubSidr;

/**
 *
 * @author Регина
 */
public class EnemyFactory {

    public static Enemy createEnemy(String enemyName, int level, int humanHealth) {
        switch (enemyName) {
            case "SonyaBlade":
                return new SonyaBlade(level);
            case "Baraka":
                return new Baraka(level);
            case "LiuKang":
                return new LiuKang(level);
            case "SubSidr":
                return new SubSidr(level);
            case "Boss":
                return new Boss(level, humanHealth);
        }
        return null;
    }
}
