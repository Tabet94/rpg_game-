package characters;

public class Mage  extends Player{

    //Constructor..............................
    public Mage(String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }

    //Methods ............................................
    public int getSpellDamage() {
        return getAttack();
    }
    public void castSpell(Character enemy){
        enemy.setHealth(getSpellDamage());
    }
}
