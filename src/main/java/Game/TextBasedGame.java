package Game;

import entities.*;
import java.util.*;
import utilities.*;

public class TextBasedGame extends game {

    private Hero hero;
    private List<Enemy> enemies;
    private Enemy boss;
    private Inventory inventory;

    public TextBasedGame() {
        inventory = new Inventory();
    }

    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game!");
        System.out.println("Enter your Hero Name: ");

        String name = sc.nextLine();
        hero = new Hero(name, 100, 1000, 10, 1);
        enemies = new ArrayList<Enemy>();
        Enemy[] enemyType = {
                new Enemy("Goblin", 50, 5, 5, 1, 10, 20),
                new Enemy("Orc", 100, 10, 10, 2, 10, 20),
                new Enemy("Troll", 150, 15, 15, 3, 10, 20),
                new Enemy("Dragon", 200, 20, 20, 4, 10, 20),
                new Enemy("Mimic", 100, 10, 10, 2, 10, 20)
        };
        enemies.addAll(Arrays.asList(enemyType));

        while (gameLoop()) {
            
        }
        endGame();

    }

    @Override
    public boolean gameLoop() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        // Random Enemy encounter
        int enemyIndex = rand.nextInt(enemies.size());
        Enemy enemy = enemies.get(enemyIndex);
        int eventPercent = rand.nextInt(100);

        if (eventPercent > 70) {
            // Encounter
            encounter(enemy);
        } else {
            // Event
            
        }
        return hero.isAlive() && enemies.stream().anyMatch(Enemy::isAlive);
    }

    @Override
    public void endGame() {
        // TODO Auto-generated method stub
        System.out.println("Game Over");
        if (hero.isAlive()) {
            System.out.println("Congratulations, " + hero.getName() + "! You have defeated the boss and saved the world!");
        } else {
            System.out.println("Unfortunately, " + hero.getName() + " has been defeated. Better luck next time!");
        }

    }

    public void foundEvent() {
        // TODO Auto-generated method stub
        // Trigger an event
        Scanner sc = new Scanner(System.in);
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

    public void encounter(Enemy enemy) {
        Random rand = new Random();
        int escapePercent = rand.nextInt(100);
        boolean escapeSuccess = false;
        System.out.println("You have encountered a " + enemy.getName());
        
        while (hero.isAlive() && enemy.isAlive() && !escapeSuccess) {
            
            System.out.println("What do you want to do?");
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Run");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Attack
                    hero.attack(enemy);
                    if(!enemy.isAlive()) {
                        System.out.println("You have defeated the " + enemy.getName());
                        break;
                    }
                    enemy.attack(hero);
                    break;
                case 2:
                    // Use Item TODO:
                    if (hero.getInventory().size() == 0) {
                        System.out.println("You have no items!");
                        break;
                    } else {
                        System.out.println("You have the following items: ");
                        inventory.printItems();
                        System.out.println("Which item do you want to use?");
                        int itemChoice = sc.nextInt();
                        if (itemChoice > hero.getInventory().size()) {
                            System.out.println("Invalid choice");
                            break;
                        } else {
                            hero.useItem(hero.getInventory().get(itemChoice - 1));
                        }
                        enemy.attack(hero);
                    }
                    break;
                case 3:
                    // Run
                    if (escapePercent > 50) {
                        System.out.println("You have escaped!");
                        escapeSuccess = true;
                        break;
                    } else {
                        enemy.attack(hero);
                        System.out.println("You failed to escape!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if(escapeSuccess) {
                break;
            }

        }

    }
    
    public void displayCurrentState() {
        System.out.println("Hero: " + hero.getName() + " - Health: " + hero.getHealth());
    }
}
