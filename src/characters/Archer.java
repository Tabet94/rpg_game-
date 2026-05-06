package characters;

public class Archer  extends Player{

    //Constructor..............................
    public Archer(String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }

    //Methods ............................................
    public int getDoubleShotDamage(){
        return getAttack()*2;

    }
    public void doubleShot(Character enemy){
        enemy.takeDamage( getAttack());
        enemy.takeDamage( getAttack());
    }
}
