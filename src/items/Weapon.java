package items;

public class Weapon extends Item {
    private final int damageBonus;

    //Constructor ...........................................................................
    public Weapon (String name, String description , int damageBonus){
        super(name, description);
        this.damageBonus = damageBonus;
    }
    //Getter ................................................................................
    public int getDamageBonus() {
        return damageBonus;
    }
}
