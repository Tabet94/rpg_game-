package characters.enemies;

import characters.Character;

public class Enemy extends Character {
    private final int expReward;
    //Constructor ...................
    public Enemy (String name, int health, int maxHealth, int attack, int defense, int expReward){
        super( name,  health,  maxHealth,  attack,  defense);
        this.expReward = expReward;

    }

    public int getExpReward() {
        return expReward;
    }
}
