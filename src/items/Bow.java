package items;

public class Bow extends Item {
    private final int damageBonus;

    //Constructor ...........................................................................
    public Bow (String name, String description , int damageBonus){
        super(name, description);
        this.damageBonus = damageBonus;
    }
    //Getter ................................................................................
    public int getDamageBonus() {
        return damageBonus;
    }
}
