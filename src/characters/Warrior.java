package characters;

public class Warrior extends Player {

    // Constructor with super .................................
    public  Warrior (String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }
    // Methods  .........................................................................
    // Warrior Attack *2 from the default Attack  .........................................................
    public int getSpecialAttackDamage() {
        return getAttack() * 2;
    }


  // ...........................................................
    public void specialAttack(Character enemy) {
        enemy.takeDamage(getSpecialAttackDamage());
    }
}
