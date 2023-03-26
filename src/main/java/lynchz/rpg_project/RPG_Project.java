package lynchz.rpg_project;

import Game.*;
import entities.*;

public class RPG_Project {

    public static void main(String[] args) {
        gamePlay();
        // testCharactor();
    }

    public static void gamePlay() {
        TextBasedGame Disgame = new TextBasedGame();
        Disgame.play();
    }

    public static void testCharactor() {
        Hero hero = new Hero("Test", 100, 1000, 10, 1);
        Enemy enemy = new Enemy("Goblin", 50, 5, 5, 1, 10, 20);

        System.out.println(hero.getHealth());
        System.out.println(enemy.getHealth());
        hero.attack(enemy);
        enemy.attack(hero);
        System.out.println(hero.getHealth());
        System.out.println(enemy.getHealth());
    }

}
