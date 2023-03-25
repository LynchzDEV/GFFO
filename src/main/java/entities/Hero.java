package entities;

import utilities.*;
import java.util.*;

public class Hero extends Character {
    private int experiencePoints;
    private int gold;
    private Weapon weapon;
    private Armor armor;
    private List<Item> inventory;

    public Hero(String name, int health, int attackPower, int defense, int level) {
        super(name, health, attackPower, defense, level);
        experiencePoints = 0;
        gold = 0;
        weapon = null;
        armor = null;
        inventory = new ArrayList<>();
    }

    public void attack(Character target) {
        if (weapon != null) {
            weapon.attack(target);
        } else {
            System.out.println(name + " attacks " + target.getName() + " with their fists.");
            target.takeDamage(attackPower);
        }
    }

    public void gainExp(int exp) {
        experiencePoints += exp;
        System.out.println(name + " gains " + exp + " experience points.");
        while (experiencePoints >= level * 17.5) {
            levelUp();
        }
    }

    public void gainGold(int gold) {
        this.gold += gold;
        System.out.println(name + " gains " + gold + " gold.");
    }

    public void levelUp() {
        level++;
        health += 10;
        attackPower += 5;
        defense += 5;
        System.out.println(name + " levels up to level " + level + ".");
    }

    public void equipWeapon(Weapon weapon) {
        if (weapon.getLevelRequirement() <= level) {
            if (this.weapon != null) {
                inventory.add(this.weapon);
            }
            this.weapon = weapon;
            inventory.remove(weapon);
            System.out.println(name + " equips " + weapon.getName() + ".");
        } else {
            System.out.println(name + " cannot equip " + weapon.getName() + " (requires level "
                    + weapon.getLevelRequirement() + ").");
        }
    }

    public void equipArmor(Armor armor){
        if(armor.getLevelRequirement() <= level) {
            if (this.armor != null) {
                inventory.add(this.armor);
            }
            this.armor = armor;
            inventory.remove(armor);
            System.out.println(name + " equips " + armor.getName() + ".");
        } else {
            System.out.println(name + " cannot equip " + armor.getName() + " (requires level "
                    + armor.getLevelRequirement() + ").");
        }
        }
    }

    public void addItemToInventory(Item item) {

    }

    public void useItem(Item item) {

    }

    public List<item> getInventory() {
        return inventory;
    }

    public int getGold() {
        return gold;
    }
}
