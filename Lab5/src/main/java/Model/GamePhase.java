/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model;

/**
 *
 * @author Регина
 */
public enum GamePhase {
    PLAYER_TURN("Ваш ход"),
    ENEMY_ANSWER("Ответ противника"),
    ENEMY_TURN("Ход противника"),
    PLAYER_ANSWER("Ваш ответ");

    private final String text;

    private GamePhase(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
