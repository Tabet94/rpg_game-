package characters;

public class Mage  extends Player{

    //Constructor..............................
    public Mage(String name){
        super( name,  90,  90,  30,  5);
    }

    //Methods ............................................
    public int getSpellDamage() {
        return getAttack();
    }
    public void castSpell(Character enemy){
        enemy.setHealth(getSpellDamage());
    }
}
