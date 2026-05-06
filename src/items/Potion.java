package items;

public class Potion extends Item {
    private final int healAmount;

    //Constructor ...........................................................................
    public Potion (String name, String description , int  healAmount){
        super(name, description);
        this. healAmount =  healAmount;
    }

    public int getHealAmount() {
        return  healAmount;
    }
}
