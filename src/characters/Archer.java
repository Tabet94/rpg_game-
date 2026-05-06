package characters;

public class Archer  extends Character{

    //Constructor..............................
    public Archer(String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }

    //Methods ............................................
    public void doubleShot(Character enemy){
        enemy.takeDamage(getAttack());
        enemy.takeDamage(getAttack());
    }
}
