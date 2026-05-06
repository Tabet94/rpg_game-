package characters;

public class Mage  extends Character{

    //Constructor..............................
    public Mage(String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }

    //Methods ............................................
    public void castSpell(Character enemy){
        enemy.setHealth(enemy.getHealth() - getAttack());
    }
}
