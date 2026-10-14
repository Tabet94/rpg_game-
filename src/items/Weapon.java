package items;

import characters.Player;


public class Weapon extends Item {
    private final int damageBonus;
    private final Class<? extends Player> allowedClass;

    //Constructor ...........................................................................
    public Weapon (String name, String description , int damageBonus, Class<? extends Player> allowedClass){
        super(name, description);
        this.damageBonus = damageBonus;
        this.allowedClass = allowedClass;
    }

    public boolean canBeUsedBy(Player player) {
        return !allowedClass.isInstance(player);
    }
    //Getter ................................................................................
    public int getDamageBonus() {
        return damageBonus;
    }
}
