package utilities;

import entities.Hero;

public class Potion extends Item {
    private String name;
    private int healingPower;

    public Potion(String name, int healingPower) {
        super(name);
        this.name = name;
        this.healingPower = healingPower;
    }

    public String getName() {
        return name;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void use(Hero hero) {
        System.out.printf("%s used %s.%n", hero.getName(), name);
        hero.heal(healingPower);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Potion{");
        sb.append("name='").append(name).append('\'');
        sb.append(", healingPower=").append(healingPower);
        sb.append('}');
        return sb.toString();
    }
}
