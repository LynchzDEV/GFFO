package entities.Class;
import java.util.List;

import utilities.*;

public class Classes {

    private int health;
    private int attackPower;
    private int defense;
    private Weapon weapon;
    private Armor armor;
    private List<Item> startingItems;
    public Classes(int health, int attackPower, int defense, Weapon weapon, Armor armor, List<Item> startingItems) {
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.weapon = weapon;
        this.armor = armor;
        this.startingItems = startingItems;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public List<Item> getStartingItems() {
        return startingItems;
    }
}


