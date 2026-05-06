package characters.enemies;

import characters.Character;

public class Orc extends Character {

    //Constructor ...................
    public Orc (String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }
    //method ...................
    public void smash(Character player){

        player.takeDamage(getAttack()*3);

    }

}
