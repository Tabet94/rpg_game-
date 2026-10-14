package items;

import characters.Archer;


    public class Bow extends Weapon {
        public Bow(String name, String description, int damageBonus) {
            super(name, description, damageBonus, Archer.class);
        }
    }


