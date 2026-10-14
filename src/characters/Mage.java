package characters;

import combat.MageSkill;

public class Mage  extends Player{

    private final int ignoreDefense;
    //Constructor..............................
    public Mage(String name){
        super( name,  90,  90,  30,  5);
        ignoreDefense = 10;
        this.setSkill(new MageSkill());
    }

    //Methods ............................................
    public int getIgnoreDefense() {
        return ignoreDefense;
    }


}
