package lynchz.rpg_project;

import Game.*;
import entities.*;
import entities.Class.*;

public class RPG_Project {

    public static void main(String[] args) {
//        gamePlay();
         testCharactor();
    }

    public static void gamePlay() {
        TextBasedGame Disgame = new TextBasedGame();
        Disgame.play();
    }

    public static void testCharactor() {
        Hero hero = new Hero("Hero", new Rogue(), 1);
        Enemy enemy = new Enemy("Goblin", 50, 5, 5, 1, 10, 20);
        System.out.println(hero);

    }

}
