package entities;

public abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int defense;
    protected int level;

    public Character(String name, int health, int attackPower, int defense, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.level = level;
    }

    public String getName(){
        return name;
    }

    public abstract void attack(Character enemy);

    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        health -= actualDamage;
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        System.out.println(name + " has died.");
    }
}
