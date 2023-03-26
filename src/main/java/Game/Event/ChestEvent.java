package Game.Event;

import entities.Hero;

import java.util.Random;
import java.util.Scanner;

public class ChestEvent extends Event {
    @Override
    public void trigger(Hero hero, Scanner sc) {
        Random rand = new Random();
        boolean badLuck = rand.nextBoolean();
        System.out.println("You have found an event!");
        System.out.println("You came across a chest! What do you want to do?");
        System.out.println("1. Open it");
        System.out.println("2. Leave it");
        int choice = sc.nextInt();
        if (choice == 1 && !badLuck) {
            // TODO:
            System.out.println("You have found! -- --");
        } else if (choice == 1 && badLuck) {
            System.out.println("The box turn into a Mimic!");
            // TODO:
            hero.takeDamage(10);
        }
    }
}
