package items;

public class Wand extends Item {
    private final int damageBonus;

    //Constructor ...........................................................................
    public Wand (String name, String description , int damageBonus){
        super(name, description);
        this.damageBonus = damageBonus;
    }
    //Getter ................................................................................
    public int getDamageBonus() {
        return damageBonus;
    }
}
