package entities;

public class Enemy extends Character {
    private int expReward;
    private int goldReward;

    public Enemy(String name, int health, int attackPower, int defense, int level, int experienceReward,
            int goldReward) {
        super(name, health, attackPower, defense, level);
        this.expReward = experienceReward;
        this.goldReward = goldReward;
            }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.name + ".");
        target.takeDamage(attackPower);
    }

    public void die() {
        super.die();
        System.out.println("You gain " + expReward + " experience and " + goldReward + " gold.");
    }
}
