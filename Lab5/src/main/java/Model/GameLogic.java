/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Fighters.enemyFactory.EnemyFactory;
import Fighters.ActionType;
import Items.Item;
import Fighters.Human;
import Fighters.enemyFactory.Enemy;
import Fighters.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import mephi.b22901.lab5.Controller;

/**
 *
 * @author Регина
 */
public class GameLogic {

    private final Controller controller;
    private GamePhase currentPhase = GamePhase.PLAYER_TURN;
    private List<Item> items;
    private Human player;
    private Enemy enemy;
    private static final String[] enemies = {"Baraka", "Liu Kang", "Sub Sidr", "Sonya Blade"};
    private static final int[] allRoundsEnemiesNumber = {2, 4, 6, 8, 10};
    private int locationsNumber;
    private int enemiesBeaten = 0;
    private static final Random random = new Random();

    public GameLogic(Controller ctrl) {
        this.controller = ctrl;
    }

    public void startGame(int locationsNum) {
        this.locationsNumber = locationsNum;
        items = new ArrayList<>(Arrays.asList(new Item("Малое зелье лечения", 0.25), new Item("Большое зелье лечения", 0.5), new Item("Крест воскрешения", 0.05)));
        player = new Human();
        newEnemy();
    }

    public void startNewRound(String stat) {
        player.levelUp(stat);
        newEnemy();
        controller.updateGUI();
    }

    private void startNewFight() {
        newEnemy();
        player.updateforNewFight();
        controller.updateGUI();
    }

    private void newEnemy() {
        int enemyIndex = random.nextInt(enemies.length);
        String enemyName = enemies[enemyIndex];
        enemy = EnemyFactory.createEnemy(enemyName, player.getLevel(), player.getHp());
    }

    public List<Item> getItems() {
        return items;
    }

    private void getNewItem() {
        double probability = Math.random();
        if (probability < 0.25) {
            int currentQuantity = items.get(0).getQuantity();
            items.get(0).setQuantity(currentQuantity + 1);
        } else if (probability < 0.4) {
            int currentQuantity = items.get(1).getQuantity();
            items.get(1).setQuantity(currentQuantity + 1);
        } else if (probability < 0.45) {
            int currentQuantity = items.get(2).getQuantity();
            items.get(2).setQuantity(currentQuantity + 1);
        }
    }

    private void getNewItemForBoss() {
        double probability = Math.random();
        if (probability < 0.375) {
            int currentQuantity = items.get(0).getQuantity();
            items.get(0).setQuantity(currentQuantity + 1);
        } else if (probability < 0.6) {
            int currentQuantity = items.get(1).getQuantity();
            items.get(1).setQuantity(currentQuantity + 1);
        } else if (probability < 0.675) {
            int currentQuantity = items.get(2).getQuantity();
            items.get(2).setQuantity(currentQuantity + 1);
        }
    }

    public void useItem(int index) {
        items.get(index).useItem(player);
    }

    public Human getHuman() {
        return player;
    }

    public Enemy getCurrentEnemy() {
        return enemy;
    }

    public void move() {
        switch (currentPhase) {
            case GamePhase.PLAYER_TURN:
                if (player.isStunned()) {
                    player.setIsStunned(false);
                    currentPhase = GamePhase.ENEMY_TURN;
                    controller.updateGUI();
                    return;
                } else {
                    currentPhase = GamePhase.ENEMY_ANSWER;
                }
                controller.updateGUI();
                updateDebuffStatus(player);
                break;

            case GamePhase.ENEMY_TURN:
                if (enemy.isStunned()) {
                    controller.updateGUI();
                    enemy.setIsStunned(false);
                    currentPhase = GamePhase.PLAYER_TURN;
                    controller.updateGUI();
                    return;
                } else {
                    ActionType enemyAction = generateMove();
                    enemy.setActionStatus(enemyAction);
                    currentPhase = GamePhase.PLAYER_ANSWER;
                }
                controller.updateGUI();
                updateDebuffStatus(enemy);
                break;

            case GamePhase.PLAYER_ANSWER:
                if (player.isStunned()) {
                    player.setIsStunned(false);
                    currentPhase = GamePhase.ENEMY_TURN;
                    return;
                } else {
                    handleActionPair(GamePhase.PLAYER_ANSWER);
                    currentPhase = GamePhase.PLAYER_TURN;
                }
                controller.updateGUI();
                updateDebuffStatus(player);
                break;

            case GamePhase.ENEMY_ANSWER:
                if (enemy.isStunned()) {
                    enemy.setIsStunned(false);
                    currentPhase = GamePhase.PLAYER_TURN;
                    return;
                } else {
                    ActionType enemyReply = generateMove();
                    enemy.setActionStatus(enemyReply);
                    handleActionPair(GamePhase.ENEMY_ANSWER);
                    currentPhase = GamePhase.ENEMY_TURN;

                }
                controller.updateGUI();
                updateDebuffStatus(enemy);
                break;
        }
        controller.updateGUI();

    }

    private void handleActionPair(GamePhase phase) {
        ActionType playerAction = player.getActionStatus();
        ActionType enemyAction = enemy.getActionStatus();
        if (phase == GamePhase.PLAYER_ANSWER) {
            handlePlayerAction(playerAction, enemyAction);
            checkEndOfRound();
        } else if (phase == GamePhase.ENEMY_ANSWER) {
            handleEnemyAction(playerAction, enemyAction);
            checkEndOfRound();
        }
    }

    private void handlePlayerAction(ActionType playerAction, ActionType enemyAction) {
        switch (enemyAction) {
            case ATTACK:
                if (playerAction == ActionType.ATTACK) {
                    applyDamage(enemy, player, false);
                } else if (playerAction == ActionType.DEFEND) {
                    applyDamage(enemy, player, true);
                } else if (playerAction == ActionType.DEBUFF) {
                    applyDamage(player, enemy, true);
                }
                break;

            case DEFEND:
                if (playerAction == ActionType.DEFEND) {
                    if (Math.random() < 0.5) {
                        player.setIsStunned(true);
                    }
                } else if (playerAction == ActionType.DEBUFF) {
                    applyDebuff(player, enemy);
                }
                break;

            case DEBUFF:
                if (playerAction == ActionType.DEFEND) {
                    applyDebuff(enemy, player);
                } else if (playerAction == ActionType.ATTACK) {
                    applyDamage(player, enemy, false);
                } else if (playerAction == ActionType.DEBUFF) {
                    applyDamage(player, enemy, false);
                    applyDamage(enemy, player, false);
                }
                break;
        }
    }

    private void handleEnemyAction(ActionType playerAction, ActionType enemyAction) {
        switch (playerAction) {
            case ATTACK:
                if (enemyAction == ActionType.ATTACK) {
                    applyDamage(player, enemy, false);
                } else if (enemyAction == ActionType.DEFEND) {
                    applyDamage(player, enemy, true);
                } else if (enemyAction == ActionType.DEBUFF) {
                    applyDamage(enemy, player, true);
                }
                break;

            case DEFEND:
                if (enemyAction == ActionType.ATTACK && enemy.getType().equals("Босс") && Math.random() < 0.15) {
                    applyDamage(enemy, player, true);
                } else if (enemyAction == ActionType.DEFEND) {
                    if (Math.random() < 0.5) {
                        enemy.setIsStunned(true);
                    }
                } else if (enemyAction == ActionType.DEBUFF) {
                    applyDebuff(enemy, player);
                }
                break;

            case DEBUFF:
                if (enemyAction == ActionType.DEFEND) {
                    applyDebuff(player, enemy);
                } else if (enemyAction == ActionType.ATTACK) {
                    applyDamage(player, enemy, false);
                } else if (enemyAction == ActionType.DEBUFF) {
                    applyDamage(player, enemy, false);
                    applyDamage(enemy, player, false);
                }
                break;
        }
    }

    private void applyDamage(Player attacker, Player defender, boolean toDivide) {
        int damage = calculateDamage(attacker, defender, toDivide);
        defender.setHp(defender.getHp() - damage);
    }

    private void applyDebuff(Player attacker, Player defender) {
        if (Math.random() < 0.75) {
            defender.setDebuffTimer(attacker.getLevel());
            defender.setIsDebuffed(true);
            int damage = calculateDamage(attacker, defender, false);
            defender.setHp(defender.getHp() - damage);
            controller.updateGUI();
        }
    }

    private int calculateDamage(Player attacker, Player defender, boolean toDivide) {
        int damage = attacker.getDamage();

        if (toDivide) {
            damage = damage / 2;
        }
        if (defender.getActionStatus() == ActionType.DEBUFF) {
            damage = (int) (damage * 1.15);
        }
        if (defender.isDebuffed()) {
            damage = (int) (damage * 1.25);
        }
        if (attacker.isDebuffed()) {
            damage = (int) (damage * 0.5);
        }
        return damage;

    }

    private ActionType generateMove() {
        ActionType playerLastAction = player.getActionStatus();
        boolean playerDebuffed = player.isDebuffed();
        int playerHP = player.getHp();
        int enemyHP = enemy.getHp();

        if (enemy.isDebuffed()) {
            if (Math.random() < 0.6) {
                return ActionType.DEFEND;
            }
            return ActionType.ATTACK;
        }

        if (enemyHP < enemy.getMaxHP() * 0.4) {
            double prob = Math.random();
            if (prob < 0.5) {
                return ActionType.DEFEND;
            }
            if (prob < 0.8) {
                return ActionType.ATTACK;
            }
            if (enemy.getType().equals("Маг")) {
                return ActionType.DEBUFF;
            }
        }

        if (playerLastAction == ActionType.ATTACK) {
            double roll = Math.random();
            if (roll < 0.4) {
                return ActionType.DEFEND;
            }
            if (roll < 0.7 && enemy.getType().equals("Маг")) {
                return ActionType.DEBUFF;
            }
            return ActionType.ATTACK;
        }

        if (playerLastAction == ActionType.DEFEND) {
            double roll = Math.random();
            if (roll < 0.5) {
                return ActionType.ATTACK;
            }
            if (roll < 0.8 && enemy.getType().equals("Маг")) {
                return ActionType.DEBUFF;
            }
            return ActionType.DEFEND;
        }

        if (playerDebuffed || playerHP < player.getMaxHP() * 0.5) {
            if (Math.random() < 0.8) {
                return ActionType.ATTACK;
            }
        }

        double roll = Math.random();
        if (roll < 0.45) {
            return ActionType.ATTACK;
        }
        if (roll < 0.7 && enemy.getType().equals("Маг")) {
            return ActionType.DEBUFF;
        }
        return ActionType.DEFEND;
    }

    private void updateDebuffStatus(Player player) {
        if (player.isDebuffed()) {
            player.setDebuffTimer(player.getDebuffTimer() - 1);
            if (player.getDebuffTimer() <= 0) {
                player.setIsDebuffed(false);
            }
        }
    }

    public GamePhase getPhase() {
        return currentPhase;
    }

    private void checkEndOfRound() {
        if (player.getHp() <= 0 && items.get(2).getQuantity() != 0) {
            useItem(2);
        } else if (player.getHp() <= 0 && items.get(2).getQuantity() == 0) {
            controller.endGame();
            return;
        } else if (enemy.getHp() <= 0) {
            player.addNewWin();
            enemiesBeaten++;
            if (enemy.getType().equals("Босс")) {
                getNewItemForBoss();
                if (player.getLevel() == locationsNumber) {
                    controller.successEndGame();
                    return;
                } else {
                    enemiesBeaten = 0;
                    controller.startNewRound();
                    return;
                }
            } else {
                getNewItem();
            }
            if (enemiesBeaten == allRoundsEnemiesNumber[player.getLevel() - 1]) {
                JOptionPane.showMessageDialog(null, "Ты дошел до конца уровня! Пришло время сразиться с боссом!", null, JOptionPane.INFORMATION_MESSAGE);
                enemy = EnemyFactory.createEnemy("Boss", player.getLevel(), player.getMaxHP());
                player.updateforNewFight();
                controller.updateGUI();
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Ты победил, боец! Но рано отдыхать, впереди новый бой!", null, JOptionPane.INFORMATION_MESSAGE);
                startNewFight();
            }
        }
    }

}
