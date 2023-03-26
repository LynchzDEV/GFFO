package Game.Event;

import entities.Hero;

import java.util.Random;
import java.util.Scanner;

public class HealingFountainEvent extends Event {

    @Override
    public void trigger(Hero hero, Scanner sc) {
        Random rand = new Random();
        System.out.println("You have found a healing fountain! Do you want to drink from it?");
        System.out.println("1. Drink from the fountain");
        System.out.println("2. Leave it");
        boolean isPoison = rand.nextInt(100) < 30; // 30% chance to be poisoned
        int choice = sc.nextInt();
        if (choice == 1 && isPoison) {
            hero.takeDamage(20);
            System.out.println("You have been poisoned!");
        } else if (choice == 1) {
            hero.heal(50); // Assuming the Hero class has a heal method
            System.out.println("You have been healed!");

        } else {
            System.out.println("You decided to leave the healing fountain.");
        }
    }
}
