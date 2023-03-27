package entities.Class;

import utilities.*;

import java.util.List;

public class Rogue extends Classes{

    private static final Weapon startingWeapon = new Weapon("Dagger", 8, 1);
    private static final Armor startingArmor = new Armor("Leather Armor", 5, 1);

    public Rogue() {
        super(125, 25, 3,
                startingWeapon, startingArmor,
                List.of(new Potion("Health Potion", 20),
                        new Potion("Stamina Potion", 15)));
    }
}
