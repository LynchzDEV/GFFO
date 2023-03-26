package Game.Event;

import entities.Hero;

import java.util.Random;
import java.util.Scanner;

public class TrappedChestEvent extends Event {

    @Override
    public void trigger(Hero hero, Scanner sc) {
        Random rand = new Random();
        System.out.println("You have found a chest! However, it seems to be trapped.");
        System.out.println("What do you want to do?");
        System.out.println("1. Attempt to disarm the trap and open it");
        System.out.println("2. Leave it");
        int choice = sc.nextInt();
        boolean trapDisarmed = rand.nextInt(100) < 70; // 70% chance to disarm the trap
        if (choice == 1) {
            if (trapDisarmed) {
                // TODO: Implement logic for finding an item in the chest
                System.out.println("You successfully disarmed the trap and found an item! -- --");
            } else {
                hero.takeDamage(20);
                System.out.println("You failed to disarm the trap and took damage!");
            }
        } else {
            System.out.println("You decided to leave the trapped chest.");
        }
    }
}

