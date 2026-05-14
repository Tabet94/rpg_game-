package characters.enemies;

import characters.Character;

public class Necromancer extends Enemy {

    //Constructor ...................
    public Necromancer (String name){
        super( name, 130, 130, 30, 10, 75);
    }
    //Method Ability : Dark Curse Ignores 25% defense ........................
    public int getDarkCurseDamage(Character player) {
        int effectiveDefence = player.getDefence() * 75 / 100;
        return getAttack() - effectiveDefence;
    }

    public void darkCurse(Character player){
        player.takeDamage(getDarkCurseDamage(player));

    }

}
