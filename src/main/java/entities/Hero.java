package entities;

import utilities.*;
import entities.Class.*;
import java.util.*;

public class Hero extends Character {
    private int experiencePoints;
    private int gold;
    private Weapon weapon;
    private Armor armor;
    private List<Item> inventory;

    public Hero(String name, Classes heroClass, int level) {
        super(name, heroClass.getHealth(), heroClass.getAttackPower(), heroClass.getDefense(), level);
        experiencePoints = 0;
        gold = 0;
        if(heroClass instanceof Warrior warrior) {
            weapon = warrior.getWeapon();
            armor = warrior.getArmor();
        } else if(heroClass instanceof Paladin paladin) {
            weapon = paladin.getWeapon();
            armor = paladin.getArmor();
        } else if(heroClass instanceof Rogue rogue){
            weapon = rogue.getWeapon();
            armor = rogue.getArmor();
        }
        inventory = heroClass.getStartingItems();
    }

    public void attack(Character target) {
        if (weapon != null) {
            weapon.attack(target);
        } else {
            System.out.println(name + " attacks " + target.getName() + " with their fists.");
            target.takeDamage(attackPower);
        }
    }

    public void heal(int healingPower) {
        health += healingPower;
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

    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println(name + " adds " + item.getName() + " to their inventory.");
    }

    public void useItem(Item item) {
        if (inventory.contains(item)) {
            item.use(this);
            inventory.remove(item);
        } else {
            System.out.println(name + " does not have " + item.getName() + " in their inventory.");
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("experiencePoints=").append(experiencePoints);
        sb.append(", gold=").append(gold);
        sb.append(", weapon=").append(weapon);
        sb.append(", armor=").append(armor);
        sb.append(", inventory=").append(inventory);
        sb.append('}');
        return sb.toString();
    }
}
