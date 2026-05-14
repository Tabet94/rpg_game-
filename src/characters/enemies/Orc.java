package characters.enemies;

import characters.Character;

public class Orc extends Enemy {

    //Constructor ...................
    public Orc (String name){
        super( name, 180, 180, 35, 20, 100 );
    }
    //method ...................
    public void smash(Character player){

        player.takeDamage(getAttack()*3);

    }

}
