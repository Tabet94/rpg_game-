package characters.enemies;

import characters.Character;

public class Goblin extends Character {

    //Constructor ...................
    public Goblin(String name, int health, int maxHealth, int attack, int defence){
        super( name,  health,  maxHealth,  attack,  defence);
    }
    //method ...................
    public void scratch(Character player){

        player.setHealth(player.getHealth() - getAttack() /2);

    }

}

