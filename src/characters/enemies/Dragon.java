package characters.enemies;

import characters.Character;

public class Dragon extends Enemy {

    //Constructor ...................
    public Dragon (String name){
        super( name, 400, 400, 45, 25, 300);
    }
    //method ...................
    public int getFireBreathDamage(){
       return (70);
    }
    public void fireBreath(Character player){
        player.takeDamage(70);
        player.setMaxHealth(player.getMaxHealth() -70 );
    }
}
