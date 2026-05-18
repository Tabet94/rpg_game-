package characters;

public class Archer  extends Player{

    //Constructor..............................
    public Archer(String name){
        super( name,  110,  110,  25,  10);
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
