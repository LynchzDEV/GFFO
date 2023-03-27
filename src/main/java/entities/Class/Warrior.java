package entities.Class;

import utilities.*;
import java.util.List;

public class Warrior extends Classes {
    private static final Weapon startingWeapon = new Weapon("Sword", 10, 1);
    private static final Armor startingArmor = new Armor("Leather Armor", 5, 1);

    public Warrior() {
        super(150, 20, 5,
                startingWeapon, startingArmor,
                List.of(new Potion("Health Potion", 20)));
    }
}
