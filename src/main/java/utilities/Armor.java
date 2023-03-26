package utilities;

import entities.Hero;

public class Armor extends Item{
    private int defensePoint;
    private int levelRequirement;

    public Armor(String name, int defensePoint, int levelRequirement) {
        super(name);
        this.defensePoint = defensePoint;
        this.levelRequirement = levelRequirement;
    }

    public int getDefence(){
        return defensePoint;
    }

    public int getLevelRequirement(){
        return levelRequirement;
    }

    @Override
    public void use(Hero hero) {
        System.out.println("you can't use this item!");
    }
}
