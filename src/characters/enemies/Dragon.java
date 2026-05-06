package characters.enemies;

import characters.Character;

public class Dragon extends Character {

    //Constructor ...................
    public Dragon (String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }
    //method ...................
    public void fireBreath(Character player){

        player.takeDamage(getAttack());
        player.setMaxHealth(player.getMaxHealth() -20 );

    }

}
