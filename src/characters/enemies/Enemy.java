package characters.enemies;

import characters.Character;

public class Enemy extends Character {
    private final int expReward;
    //Constructor ...................
    public Enemy (String name, int health, int maxHealth, int attack, int defence, int expReward){
        super( name,  health,  maxHealth,  attack,  defence);
        this.expReward = expReward;

    }

    public int getExpReward() {
        return expReward;
    }
}
