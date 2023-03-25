package utilities;

import entities.Character;

public class Weapon extends Item {
    private int attackPower;
    private int levelRequirement;

    public Weapon(String name, int attackPower, int levelRequirement) {
        super(name);
        this.attackPower = attackPower;
        this.levelRequirement = levelRequirement;
    }

    public void attack(Character target) {
        System.out.println("You attack " + target.getName() + " with " + getName() + ".");
        target.takeDamage(attackPower);
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }
}
