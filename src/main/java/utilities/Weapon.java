package utilities;

import entities.Character;
import entities.Hero;

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
        System.out.println(target.getName() + " takes " + attackPower + " damage.");
        System.out.println(target.getName() + " has " + target.getHealth() + " health left.");
        target.takeDamage(attackPower);
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Override
    public void use(Hero hero) {
        System.out.println("you can't use this item!");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Weapon{");
        sb.append("Name=").append(getName());
        sb.append(",attackPower=").append(attackPower);
        sb.append(", levelRequirement=").append(levelRequirement);
        sb.append('}');
        return sb.toString();
    }
}
