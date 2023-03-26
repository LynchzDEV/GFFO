package entities.Class;

import utilities.*;
import java.util.List;

public class Paladin extends Classes{

    private static final Weapon startingWeapon = new Weapon("Long Sword", 10, 1);
    private static final Armor startingArmor = new Armor("Chain Mail", 7, 2);

    public Paladin() {
        super(175, 15, 8,
                startingWeapon, startingArmor,
                List.of(new Potion("Health Potion", 20),
                        new Potion("Mana Potion", 10)));
    }
}
