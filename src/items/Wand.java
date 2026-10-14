package items;

import characters.Mage;

public class Wand extends Weapon {

    public Wand(String name, String description, int damageBonus) {
        super(name, description, damageBonus, Mage.class);
    }
}
